package net.mcg_server.ecm.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddAccountWindow {

	//--------------
	//  Variables
	//--------------
	JFrame frame;
	final static boolean shouldFill = true;


	//---------------
	//  Constructor
	//---------------
	public AddAccountWindow(){
		initialize();
		frame.setVisible(true);
	}


	// INITIALIZE
	/*
	 * Creates the Add Account window
	 */
	private void initialize(){

		//create the frame and set properties
		frame = new JFrame("Add Account");
		frame.setBounds(100,100,300,200);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);

		//create the panel and define the layout
		JPanel panel = new JPanel(new GridBagLayout());

		//define layout constraints
		GridBagConstraints c = new GridBagConstraints();
		if(shouldFill){
			//natural height, max width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		//add the panel to the frame
		frame.add(panel);

		//create label and define its position
		JLabel keyIdLabel = new JLabel("  KeyID: ");
		c.gridx = 1;
		c.gridwidth = 1;
		c.gridy = 0;
		panel.add(keyIdLabel, c);

		//create text field and define its position
		JTextField keyId = new JTextField();
		c.gridx = 2;
		c.gridy = 0;
		panel.add(keyId, c);

		//create label and define its position
		JLabel vCodeLabel = new JLabel("  vCode: ");
		c.gridx = 1;
		c.gridy = 2;
		panel.add(vCodeLabel, c);

		//create text field and define its position
		JTextField vCode = new JTextField();
		c.gridx = 2;
		c.gridy = 2;
		c.ipady = 30;
		panel.add(vCode, c);

		//create button and define its position
		JButton addAcctButton = new JButton("Add Account");
		c.ipady = 0;
		c.gridx = 2;
		c.gridy = 4;
		panel.add(addAcctButton, c);


		// EVENT LISTENER
		//close the window
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				AccountManageWindow.addAcctOpen = false;
				AccountManageWindow.preventClose = false;
				frame.dispose();
			}
		});

		// EVENT LISTENER
		// add account then close window
		addAcctButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					//addAccount(keyID, vCode);
				}catch(Exception x){

				}
				AccountManageWindow.addAcctOpen = false;
				AccountManageWindow.preventClose = false;
				frame.dispose();

			}
		});
	}

}
