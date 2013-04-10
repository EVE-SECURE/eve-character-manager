package net.mcg_server.ecm;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import net.mcg_server.ecm.ui.AccountManageWindow;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class ECM {

	//-------------
	//  variables
	//-------------
	JFrame mainFrame;
	JPanel mainPanel;
	JPanel skillPanel;
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenu viewMenu;
	JMenuItem manageAcct;
	JMenuItem closeApp;
	JMenuItem miMainPanel;
	JMenuItem miSkillPanel;
	CardLayout cl = new CardLayout(0,0);
	public static boolean manageAcctOpen = false;

	
	
	//---------------
	//     MAIN
	//---------------
	public static void main(String[] args){

		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try{
					ECM window = new ECM();
					window.mainFrame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});

	}


	
	//---------------
	//  CONSTRUCTOR
	//---------------
	public ECM(){
		initialize();
	}

	
	//---------------
	//  INITIALIZE
	//---------------
	
	/*
	 * This method is designed to draw the basic UI layout, including the Menu bar and menu options/items
	 */
	private void initialize(){
		
		// create main application frame
		mainFrame = new JFrame("EVE Character Manager");
		mainFrame.setBounds(100,100,800,600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(cl);

		// initialize and add main panel
		mainPanel = new JPanel();
		mainFrame.getContentPane().add(mainPanel, "mainPanel");

		// initialize and add skill panel
		skillPanel = new JPanel();
		mainFrame.getContentPane().add(skillPanel, "skillPanel");
		mainFrame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mainPanel,skillPanel}));

		//add menu bar
		menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);

		//add menus
		fileMenu = new JMenu("File");
		viewMenu = new JMenu("View");
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);

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

		//add some UI Elements to the Main and Skills panels
		JLabel label1 = new JLabel("Main Panel");
		JLabel label2 = new JLabel("Skills Panel");
		mainPanel.add(label1);
		skillPanel.add(label2);


		//Add Event Listeners to the menu items
		//display mainPanel
		miMainPanel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cl.show(mainFrame.getContentPane(), "mainPanel");

			}
		});

		//displaySkillPanel
		miSkillPanel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cl.show(mainFrame.getContentPane(), "skillPanel");
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
