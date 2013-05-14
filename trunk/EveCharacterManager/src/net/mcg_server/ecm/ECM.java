package net.mcg_server.ecm;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.mcg_server.ecm.ui.MainPanel;
import net.mcg_server.ecm.ui.SkillsPanel;
import net.mcg_server.ecm.ui.menu.MenuBar;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class ECM {

	//-------------
	//  variables
	//-------------
	JFrame mainFrame;
	JPanel mainPanel;
	JPanel skillPanel;
	MenuBar menuBar;
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
		mainPanel = new MainPanel();
		mainFrame.getContentPane().add(mainPanel, "mainPanel");

		// initialize and add skill panel
		skillPanel = new SkillsPanel();
		mainFrame.getContentPane().add(skillPanel, "skillPanel");
		mainFrame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{mainPanel,skillPanel}));
		
		//add menu bar
		menuBar = new MenuBar(this, mainFrame);
		mainFrame.setJMenuBar(menuBar);

	}
	
	
	
	//---------------
	// METHODS
	//---------------
	
	public JFrame getMainFrame(){
		return mainFrame;
	}

	public void showMainPanel(){
		cl.show(mainFrame.getContentPane(), "mainPanel");
	}
	
	public void showSkillPanel(){
		cl.show(mainFrame.getContentPane(), "skillPanel");
	}
}
