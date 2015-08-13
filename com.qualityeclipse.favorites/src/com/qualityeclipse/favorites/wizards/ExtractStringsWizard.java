package com.qualityeclipse.favorites.wizards;

import java.awt.BorderLayout;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import com.qualityeclipse.favorites.FavoritesActivator;
import com.qualityeclipse.favorites.FavoritesLog;
import com.qualityeclipse.favorites.wizards.Utils.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ExtractStringsWizard extends Wizard{
	private IStructuredSelection initialSelection;
	protected SelectFilesWizardPage one;
	  protected SelectStringsWizardPage two;
	  
	 //public static Vector<String>[] strarrlist = (Vector<String>[]) new Vector[3];
	  static public Vector st0 =  new Vector(10); static public Vector st1 =  new Vector(10);
	  static public Vector st2 =  new Vector(10);static public Vector st3 =  new Vector(10);
	  static public Vector st4 =  new Vector(10);static public Vector st5 =  new Vector(10);
	  static public Vector st6 =  new Vector(10);static public Vector st7 =  new Vector(10);
	  static public Vector st8 =  new Vector(10);static public Vector st9 =  new Vector(10);
	  static public Vector st10 =  new Vector(10);static public Vector st11 =  new Vector(10);
	  static public Vector st12 =  new Vector(10);static public Vector st13 =  new Vector(10);
	  static public Vector st14 =  new Vector(10);static public Vector st15 =  new Vector(10);
	  static public Vector st16 =  new Vector(10);
	  public static Vector v = new Vector(1);
	  public static boolean[] flag = new boolean[20];
	public ExtractStringsWizard() {
		IDialogSettings favoritesSettings =
            FavoritesActivator.getDefault().getDialogSettings();
      IDialogSettings wizardSettings =
            favoritesSettings.getSection("ExtractStringsWizard");
      if (wizardSettings == null)
         wizardSettings = favoritesSettings.addNewSection("ExtractStringsWizard");
      setDialogSettings(favoritesSettings);
	  }

	  @Override
	  public String getWindowTitle() {
	    return "Export My Data";
	  }

	  @Override
	  public void addPages() {
	    one = new SelectFilesWizardPage();
	    two = new SelectStringsWizardPage();
	    addPage(one);
	    addPage(two);
	    one.init(initialSelection);
	  }

	  @Override
	  public boolean performFinish() {
		  JFrame frame = new JFrame();
		  frame.add( new JLabel(" Outout" ), BorderLayout.CENTER );
	        JTextArea ta = new JTextArea(25,50);
	        CustomOutputStream taos = new CustomOutputStream( ta, 600 );
	        PrintStream ps = new PrintStream( taos );
	        System.setOut( ps );
	        System.setErr( ps );
	        frame.add( new JScrollPane( ta )  );

	        frame.pack();
	        frame.setVisible( true );

		  
	    // Print the result to the console
		  one = new SelectFilesWizardPage();
		    two = new SelectStringsWizardPage();
		    v.add("body");
		    //strarrlist = new ArrayList<ArrayList<String>>;
		    final TableItem [] items = two.checkboxTableViewer.getTable().getItems();//System.out.println(items.length);
		    Arrays.fill(flag, Boolean.FALSE);
		      for (int i = 0; i < items.length; ++i) {
		        if (items[i].getChecked()){
		        	//System.out.println(items[i].getText(1));
		        	if(items[i].getText()=="commit_comments"){
		        	st0.add(items[i].getText(1));
		        	flag[0] = true;
		        	}else if(items[i].getText()=="commits"){
		        	st1.add(items[i].getText(1));
		        	flag[1] = true;
		        	}else if(items[i].getText()=="followers"){
		        	st2.add(items[i].getText(1));
		        	flag[2] = true;
		        	}else if(items[i].getText()=="issue_comments"){
		        	st3.add(items[i].getText(1));
		        	flag[3] = true;
		        	}else if(items[i].getText()=="issue_events"){
		        	st4.add(items[i].getText(1));
		        	flag[4] = true;
		        	}else if(items[i].getText()=="issues"){
		        	st5.add(items[i].getText(1));
		        	flag[5] = true;
		        	}else if(items[i].getText()=="organization_members"){
		        	st6.add(items[i].getText(1));flag[6] = true;
		        	}else if(items[i].getText()=="project_commits"){
		        	st7.add(items[i].getText(1));flag[7] = true;
		        	}else if(items[i].getText()=="project_members"){
		        	st8.add(items[i].getText(1));flag[8] = true;
		        	}else if(items[i].getText()=="projects"){
		        	st9.add(items[i].getText(1));flag[9] = true;
		        	}else if(items[i].getText()=="projects_with_forks"){
		        	st10.add(items[i].getText(1));flag[10] = true;
		        	}else if(items[i].getText()=="pull_request_comments"){
		        	st11.add(items[i].getText(1));flag[11] = true;
		        	}else if(items[i].getText()=="pull_request_commits"){
		        	st12.add(items[i].getText(1));flag[12] = true;
		        	}else if(items[i].getText()=="pull_request_history"){
		        	st13.add(items[i].getText(1));flag[13] = true;
		        	}else if(items[i].getText()=="pull_requests"){
		        	st14.add(items[i].getText(1));flag[14] = true;
		        	}else if(items[i].getText()=="users"){
		        	st15.add(items[i].getText(1));flag[15] = true;
		        	}else if(items[i].getText()=="watchers"){
		        	st16.add(items[i].getText(1));flag[16] = true;
		        	}
		        }
		        
		      }
		      
		   // final ExtractedString[] extracted = two.getSelection();
		    //System.out.println(extracted[1].getKey());
		 
		Constants  con = new Constants(); 
		con.func();
		      
	    File path = new File(one.holder1);
	    File path2 = new File(one.holder2);
	    GHFolderToTSV gh = new GHFolderToTSV();
		gh.convertAllFilseInFolderToTSV(path,path2, 10000);
		/*
		final ExtractedString[] extracted = two.getSelection();
	    for (int i = 0; i < extracted.length; i++) {
	    	System.out.println(extracted[i]);
	    }*/
				frame.dispose();
			    return true;
	  }

	public IPath getSourceLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	 public void init(IWorkbench workbench, IStructuredSelection selection) {
	      initialSelection = selection;
	   }

}