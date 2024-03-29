package net.mcg_server.ecm.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.mcg_server.ecm.ui.menu.MenuBar;

public class AccountManageWindow {

	//--------------
	//  Variables
	//--------------
	static JFrame frame;
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	public static boolean addAcctOpen = false;
	public static boolean preventClose = false;

	
	//----------------
	//  Constructor
	//----------------
	public AccountManageWindow(){
		initialize();
		frame.setVisible(true);
	}

	
	// INITIALIZE
	/*
	 * Creates the Account Management window
	 */
	private void initialize(){
		
		//Create the frame
		frame = new JFrame("Account Management");
		frame.setBounds(100,100,400,150);
		frame.setAlwaysOnTop(true);

		//create the panel and set the layout
		JPanel panel = new JPanel(new GridBagLayout());

		//define the layout constraints
		GridBagConstraints c = new GridBagConstraints();
		if(shouldFill){
			//natural height, max width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		//add the panel to the frame
		frame.add(panel);

		//add a text area and define it's position in the layout
		JLabel description = new JLabel("<html>This is where the page description goes. <br />" +
				"More Text here using the 'br' html tag.</html>");
		//description.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(description, c);
		
		//add a spacer row between the label and the button
		JLabel spacer = new JLabel("<html><br /></html>");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(spacer, c);

		//add the Add Account button and define it's position in the layout
		JButton button = new JButton("Add Account");
		c.gridx = 0;
		c.gridy = 2;
		panel.add(button, c);

		
		// EVENT LISTENERS
		//open AddAccountWindow
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// open AddAccountWindow
				if(!addAcctOpen){
					addAcctOpen = true;
					preventClose = true;
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					new AddAccountWindow();
				}
			}
		});

		//close AccountManageWindow
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				if(!preventClose){
					MenuBar.manageAcctOpen = false;
					frame.dispose();
				}
			}
		});
	}
}
