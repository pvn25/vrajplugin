package com.qualityeclipse.favorites.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;

import com.qualityeclipse.favorites.FavoritesActivator;
import com.qualityeclipse.favorites.FavoritesLog;

public class FavoritesManager
   implements IResourceChangeListener
{
   private static final String TAG_FAVORITES = "Favorites";
   private static final String TAG_FAVORITE = "Favorite";
   private static final String TAG_TYPEID = "TypeId";
   private static final String TAG_INFO = "Info";

   private static FavoritesManager manager;
   private Collection<IFavoriteItem> favorites;
   private List<FavoritesManagerListener> listeners =
         new ArrayList<FavoritesManagerListener>();

   private FavoritesManager() {
      ResourcesPlugin.getWorkspace().addResourceChangeListener (
         this, IResourceChangeEvent.POST_CHANGE);
   }

   // /////////////////////////////////////////////////////////////////////////
   //
   // Singleton
   //
   // /////////////////////////////////////////////////////////////////////////

   public static FavoritesManager getManager() {
      if (manager == null)
         manager = new FavoritesManager();
      return manager;
   }
   
   public static void shutdown() {
      if (manager != null) {
         ResourcesPlugin.getWorkspace()
            .removeResourceChangeListener(manager);
         manager.saveFavorites();
         manager = null;
      }
   }

   // /////////////////////////////////////////////////////////////////////////
   //
   // Accessing Favorite Items
   //
   // /////////////////////////////////////////////////////////////////////////

   public IFavoriteItem[] getFavorites() {
      if (favorites == null)
         loadFavorites();
      return favorites.toArray(new IFavoriteItem[favorites.size()]);
   }

   public void addFavorites(Object[] objects) {
      if (objects == null)
         return;
      if (favorites == null)
         loadFavorites();
      Collection<IFavoriteItem> items =
            new HashSet<IFavoriteItem>(objects.length);
      for (int i = 0; i < objects.length; i++) {
         IFavoriteItem item = existingFavoriteFor(objects[i]);
         if (item == null) {
            item = newFavoriteFor(objects[i]);
            if (favorites.add(item))
               items.add(item);
         }
      }
      if (items.size() > 0) {
         IFavoriteItem[] added =
               items.toArray(new IFavoriteItem[items.size()]);
         fireFavoritesChanged(added, IFavoriteItem.NONE);
      }
   }

   public void removeFavorites(Object[] objects) {
      if (objects == null)
         return;
      if (favorites == null)
         loadFavorites();
      Collection<IFavoriteItem> items =
            new HashSet<IFavoriteItem>(objects.length);
      for (int i = 0; i < objects.length; i++) {
         IFavoriteItem item = existingFavoriteFor(objects[i]);
         if (item != null && favorites.remove(item))
            items.add(item);
      }
      if (items.size() > 0) {
         IFavoriteItem[] removed =
               items.toArray(new IFavoriteItem[items.size()]);
         fireFavoritesChanged(IFavoriteItem.NONE, removed);
      }
   }

   public IFavoriteItem newFavoriteFor(Object obj) {
      FavoriteItemType[] types = FavoriteItemType.getTypes();
      for (int i = 0; i < types.length; i++) {
         IFavoriteItem item = types[i].newFavorite(obj);
         if (item != null)
            return item;
      }
      return null;
   }

   private IFavoriteItem existingFavoriteFor(Object obj) {
      if (obj == null)
         return null;
      if (obj instanceof IFavoriteItem)
         return (IFavoriteItem) obj;
      Iterator<IFavoriteItem> iter = favorites.iterator();
      while (iter.hasNext()) {
         IFavoriteItem item = iter.next();
         if (item.isFavoriteFor(obj))
            return item;
      }
      return null;
   }

   public IFavoriteItem[] existingFavoritesFor(Iterator<?> iter) {
      List<IFavoriteItem> result = new ArrayList<IFavoriteItem>(10);
      while (iter.hasNext()) {
         IFavoriteItem item = existingFavoriteFor(iter.next());
         if (item != null)
            result.add(item);
      }
      return (IFavoriteItem[]) result.toArray(new IFavoriteItem[result.size()]);
   }

   // /////////////////////////////////////////////////////////////////////////
   //
   // Event Handling
   //
   // /////////////////////////////////////////////////////////////////////////

   public void addFavoritesManagerListener(
         FavoritesManagerListener listener) {
      if (!listeners.contains(listener))
         listeners.add(listener);
   }

   public void removeFavoritesManagerListener(
         FavoritesManagerListener listener) {
      listeners.remove(listener);
   }

   private void fireFavoritesChanged(IFavoriteItem[] itemsAdded,
         IFavoriteItem[] itemsRemoved) {
      FavoritesManagerEvent event =
            new FavoritesManagerEvent(this, itemsAdded, itemsRemoved);
      for (Iterator<FavoritesManagerListener> iter =
            listeners.iterator(); iter.hasNext();)
         iter.next().favoritesChanged(event);
   }

   // /////////////////////////////////////////////////////////////////////////
   //
   // Persisting favorites
   //
   // /////////////////////////////////////////////////////////////////////////

   private void loadFavorites() {
      favorites = new HashSet<IFavoriteItem>(20);
      FileReader reader = null;
      try {
         reader = new FileReader(getFavoritesFile());
         loadFavorites(XMLMemento.createReadRoot(reader));
      }
      catch (FileNotFoundException e) {
         // Ignored... no Favorites items exist yet.
      }
      catch (Exception e) {
         // Log the exception and move on.
         FavoritesLog.logError(e);
      }
      finally {
         try {
            if (reader != null)
               reader.close();
         }
         catch (IOException e) {
            FavoritesLog.logError(e);
         }
      }
   }

   private void loadFavorites(XMLMemento memento) {
      IMemento[] children = memento.getChildren(TAG_FAVORITE);
      for (int i = 0; i < children.length; i++) {
         IFavoriteItem item =
               newFavoriteFor(children[i].getString(TAG_TYPEID),
                     children[i].getString(TAG_INFO));
         if (item != null)
            favorites.add(item);
      }
   }

   public IFavoriteItem newFavoriteFor(String typeId, String info) {
      FavoriteItemType[] types = FavoriteItemType.getTypes();
      for (int i = 0; i < types.length; i++)
         if (types[i].getId().equals(typeId))
            return types[i].loadFavorite(info);
      return null;
   }

   public void saveFavorites() {
      if (favorites == null)
         return;
      XMLMemento memento = XMLMemento.createWriteRoot(TAG_FAVORITES);
      saveFavorites(memento);
      FileWriter writer = null;
      try {
         writer = new FileWriter(getFavoritesFile());
         memento.save(writer);
      }
      catch (IOException e) {
         FavoritesLog.logError(e);
      }
      finally {
         try {
            if (writer != null)
               writer.close();
         }
         catch (IOException e) {
            FavoritesLog.logError(e);
         }
      }
   }

   private void saveFavorites(XMLMemento memento) {
      Iterator<IFavoriteItem> iter = favorites.iterator();
      while (iter.hasNext()) {
         IFavoriteItem item = iter.next();
         IMemento child = memento.createChild(TAG_FAVORITE);
         child.putString(TAG_TYPEID, item.getType().getId());
         child.putString(TAG_INFO, item.getInfo());
      }
   }

   private File getFavoritesFile() {
      return FavoritesActivator.getDefault()
            .getStateLocation()
            .append("favorites.xml")
            .toFile();
   }

   ////////////////////////////////////////////////////////////////////////////
   //
   // Resource change event handling
   //
   ////////////////////////////////////////////////////////////////////////////

   /**
    * Called by the system when some resource changes are happening,
    * or have already happened. The supplied event gives details. This
    * event object (and the resource delta within it) is valid only
    * for the duration of the invocation of this method.
    */
   public void resourceChanged(IResourceChangeEvent event) {
      
      // Uncomment this section to show the resource change event

      /*
      System.out.println(
         "FavoritesManager - resource change event");
      try {
         event.getDelta().accept(new IResourceDeltaVisitor() {
            public boolean visit(IResourceDelta delta)
               throws CoreException
            {
               StringBuffer buf = new StringBuffer(80);
               switch (delta.getKind()) {
                  case IResourceDelta.ADDED:
                     buf.append("ADDED");
                     break;
                  case IResourceDelta.REMOVED:
                     buf.append("REMOVED");
                     break;
                  case IResourceDelta.CHANGED:
                     buf.append("CHANGED");
                     break;
                  default:
                     buf.append("[");
                     buf.append(delta.getKind());
                     buf.append("]");
                     break;
               }
               buf.append(" ");
               buf.append(delta.getResource());
               System.out.println(buf);
               return true;
            }
         });
      }
      catch (CoreException ex) {
         FavoritesLog.logError(ex);
      }
      */
      
      final Collection<IFavoriteItem> itemsToRemove = new HashSet<IFavoriteItem>();
      try {
         event.getDelta().accept(new IResourceDeltaVisitor() {
            public boolean visit(IResourceDelta delta) throws CoreException {
               if (delta.getKind() == IResourceDelta.REMOVED) {
                  IFavoriteItem item = existingFavoriteFor(delta.getResource());
                  if (item != null)
                     itemsToRemove.add(item);
               }
               return true;
            }
         });
      }
      catch (CoreException ex) {
         FavoritesLog.logError(ex);
      }
      if (itemsToRemove.size() > 0)
         removeFavorites(itemsToRemove.toArray(new IFavoriteItem[itemsToRemove.size()]));
   }
}
