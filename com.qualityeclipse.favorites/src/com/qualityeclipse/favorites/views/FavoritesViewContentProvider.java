package com.qualityeclipse.favorites.views;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import com.qualityeclipse.favorites.model.FavoritesManager;
import com.qualityeclipse.favorites.model.FavoritesManagerEvent;
import com.qualityeclipse.favorites.model.FavoritesManagerListener;

class FavoritesViewContentProvider
      implements IStructuredContentProvider, FavoritesManagerListener
{
   private TableViewer viewer;
   private FavoritesManager manager;

   public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
      this.viewer = (TableViewer) viewer;
      if (manager != null)
         manager.removeFavoritesManagerListener(this);
      manager = (FavoritesManager) newInput;
      if (manager != null)
         manager.addFavoritesManagerListener(this);
   }

   public void dispose() {
   }

   public Object[] getElements(Object parent) {
      return manager.getFavorites();
   }

   public void favoritesChanged(final FavoritesManagerEvent event) {
      // If this is the UI thread, then make the change.
      if (Display.getCurrent() != null) {
         updateViewer(event);
         return;
      }

      // otherwise, redirect to execute on the UI thread.
      Display.getDefault().asyncExec(new Runnable() {
         public void run() {
            updateViewer(event);
         }
      });
   }

   private void updateViewer(FavoritesManagerEvent event) {
      // Use the setRedraw method to reduce flicker
      // when adding or removing multiple items in a table.
      viewer.getTable().setRedraw(false);
      try {
         viewer.remove(event.getItemsRemoved());
         viewer.add(event.getItemsAdded());
      }
      finally {
         viewer.getTable().setRedraw(true);
      }
   }
}