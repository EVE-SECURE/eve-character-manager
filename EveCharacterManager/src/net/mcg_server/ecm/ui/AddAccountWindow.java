package net.mcg_server.ecm.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
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
		frame.setBounds(100,100,400,300);
		frame.setAlwaysOnTop(true);
		
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
		
		//create empty space
		Box box1 = new Box(0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 5;
		panel.add(box1, c);

		//create label and define its position
		JLabel keyIdLabel = new JLabel("  KeyID: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.3;
		c.ipady = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(keyIdLabel, c);

		//create text field and define its position
		JTextField keyId = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.ipady = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(keyId, c);

		//create label and define its position
		JLabel vCodeLabel = new JLabel("  vCode: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.3;
		c.ipady = 1;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(vCodeLabel, c);

		//create text field and define its position
		JTextField vCode = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.7;
		c.ipady = 1;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(vCode, c);
		
		//create button and define its position
		JButton addAcctButton = new JButton("Add Account");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
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
	}

}
