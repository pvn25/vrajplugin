package com.qualityeclipse.favorites.dialogs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.qualityeclipse.favorites.model.FavoriteItemType;

/**
 * A specialized filter dialog for the Favorites view that presents the user the
 * option of filtering content based on name, type, or location. The dialog
 * restricts itself to presenting and gathering information from the user and
 * providing accessor methods for the filter action.
 */
public class FavoritesFilterDialog extends Dialog
{
   private String namePattern;
   private String locationPattern;
   private Collection<FavoriteItemType> selectedTypes;
   private Map<FavoriteItemType, Button> typeFields;

   private Text locationPatternField;
   private Text namePatternField;

   /**
    * Creates a dialog instance. Note that the window will have no visual
    * representation (no widgets) until it is told to open. By default,
    * <code>open</code> blocks for dialogs.
    * 
    * @param parentShell
    *           the parent shell, or <code>null</code> to create a top-level
    *           shell
    */
   public FavoritesFilterDialog(Shell parentShell, String namePattern,
         String locationPattern, FavoriteItemType[] selectedTypes) {
      super(parentShell);
      this.namePattern = namePattern;
      this.locationPattern = locationPattern;
      this.selectedTypes = new HashSet<FavoriteItemType>();
      for (int i = 0; i < selectedTypes.length; i++)
         this.selectedTypes.add(selectedTypes[i]);
   }

   /**
    * Creates and returns the contents of the upper part of this dialog (above
    * the button bar).
    * 
    * @param parent
    *           the parent composite to contain the dialog area
    * @return the dialog area control
    */
   protected Control createDialogArea(Composite parent) {
      Composite container = (Composite) super.createDialogArea(parent);
      final GridLayout gridLayout = new GridLayout();
      gridLayout.numColumns = 2;
      container.setLayout(gridLayout);

      final Label filterLabel = new Label(container, SWT.NONE);
      filterLabel.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false,
            false, 2, 1));
      filterLabel.setText("Enter a filter (* = any number of "
            + "characters, ? = any single character)"
            + "\nor an empty string for no filtering:");

      final Label nameLabel = new Label(container, SWT.NONE);
      nameLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));
      nameLabel.setText("Name:");

      namePatternField = new Text(container, SWT.BORDER);
      namePatternField.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true,
            false));

      final Label locationLabel = new Label(container, SWT.NONE);
      final GridData gridData = new GridData(GridData.END, GridData.CENTER, false, false);
      gridData.horizontalIndent = 20;
      locationLabel.setLayoutData(gridData);
      locationLabel.setText("Location:");

      locationPatternField = new Text(container, SWT.BORDER);
      locationPatternField.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
            true, false));

      final Label typesLabel = new Label(container, SWT.NONE);
      typesLabel.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, false,
            false, 2, 1));
      typesLabel.setText("Select the types of favorites to be shown:");

      final Composite typeCheckboxComposite = new Composite(container, SWT.NONE);
      final GridData gridData_1 =
            new GridData(GridData.FILL, GridData.FILL, false, false, 2, 1);
      gridData_1.horizontalIndent = 20;
      typeCheckboxComposite.setLayoutData(gridData_1);
      final GridLayout typeCheckboxLayout = new GridLayout();
      typeCheckboxLayout.numColumns = 2;
      typeCheckboxComposite.setLayout(typeCheckboxLayout);

      createTypeCheckboxes(typeCheckboxComposite);
      initContent();
      return container;
   }

   /**
    * Create one checkbox for each type of favorite items
    * 
    * @param parent
    *           the composite to contain the checkboxes
    */
   private void createTypeCheckboxes(Composite parent) {
      typeFields = new HashMap<FavoriteItemType, Button>();
      FavoriteItemType[] allTypes = FavoriteItemType.getTypes();
      for (int i = 0; i < allTypes.length; i++) {
         final FavoriteItemType eachType = allTypes[i];
         if (eachType == FavoriteItemType.UNKNOWN)
            continue;
         final Button button = new Button(parent, SWT.CHECK);
         button.setText(eachType.getName());
         typeFields.put(eachType, button);
         button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
               if (button.getSelection())
                  selectedTypes.add(eachType);
               else
                  selectedTypes.remove(eachType);
            }
         });
      }
   }

   /**
    * Initialize the various fields in the dialog
    */
   private void initContent() {
      namePatternField.setText(namePattern != null ? namePattern : "");
      namePatternField.addModifyListener(new ModifyListener() {
         public void modifyText(ModifyEvent e) {
            namePattern = namePatternField.getText();
         }
      });

      locationPatternField.setText(locationPattern != null ? locationPattern : "");
      locationPatternField.addModifyListener(new ModifyListener() {
         public void modifyText(ModifyEvent e) {
            locationPattern = locationPatternField.getText();
         }
      });

      FavoriteItemType[] allTypes = FavoriteItemType.getTypes();
      for (int i = 0; i < allTypes.length; i++) {
         FavoriteItemType eachType = allTypes[i];
         if (eachType == FavoriteItemType.UNKNOWN)
            continue;
         Button button = typeFields.get(eachType);
         button.setSelection(selectedTypes.contains(eachType));
      }
   }

   /**
    * Configures the given shell in preparation for opening this window in it.
    * In this case, we set the dialog title.
    */
   protected void configureShell(Shell newShell) {
      super.configureShell(newShell);
      newShell.setText("Favorites View Filter Options");
   }

   /**
    * Answer the user specified name pattern
    * 
    * @return the pattern (not <code>null</code>)
    */
   public String getNamePattern() {
      return namePattern;
   }

   /**
    * Answer the user specified location pattern
    * 
    * @return the pattern (not <code>null</code>)
    */
   public String getLocationPattern() {
      return locationPattern;
   }

   /**
    * Answer the user selected favorite item types
    * 
    * @return an array of <code>FavoriteItemType</code> (not <code>null</code>,
    *         contains no <code>null</code>s)
    */
   public FavoriteItemType[] getSelectedTypes() {
      return selectedTypes.toArray(new FavoriteItemType[selectedTypes.size()]);
   }
}
