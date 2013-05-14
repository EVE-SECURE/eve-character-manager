package net.mcg_server.ecm.ui.menu;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import net.mcg_server.ecm.ECM;
import net.mcg_server.ecm.ui.AccountManageWindow;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar{
	

	JFrame mainFrame;
	JMenu fileMenu;
	JMenu viewMenu;
	JMenuItem manageAcct;
	JMenuItem closeApp;
	JMenuItem miMainPanel;
	JMenuItem miSkillPanel;
	CardLayout cl = new CardLayout(0,0);
	public static boolean manageAcctOpen = false;

	
	//---------------
	//  CONSTRUCTOR
	//---------------
	public MenuBar(final ECM ecm, JFrame pMainFrame){
		
		this.mainFrame = pMainFrame;
		mainFrame.setJMenuBar(this);
		
		//add menus
		fileMenu = new JMenu("File");
		viewMenu = new JMenu("View");
		this.add(fileMenu);
		this.add(viewMenu);

		//add file menu items
		manageAcct = new JMenuItem("Manage Accounts");
		closeApp = new JMenuItem("Close");
		fileMenu.add(manageAcct);
		fileMenu.add(closeApp);

		//add view menu items
		miMainPanel = new JMenuItem("Main");
		miSkillPanel = new JMenuItem("Skills");
		viewMenu.add(miMainPanel);
		viewMenu.add(miSkillPanel);

		//Add Event Listeners to the menu items
		//display mainPanel
		miMainPanel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				
				//show main panel
				ecm.showMainPanel();
			}
		});

		//displaySkillPanel
		miSkillPanel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				//show skill panel
				ecm.showSkillPanel();
			}
		});
		
		//open AccountManageWindow
		manageAcct.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(!manageAcctOpen){
					manageAcctOpen = true;
					new AccountManageWindow();
				}
			}
		});

		//close the application
		closeApp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
	}
	
}
