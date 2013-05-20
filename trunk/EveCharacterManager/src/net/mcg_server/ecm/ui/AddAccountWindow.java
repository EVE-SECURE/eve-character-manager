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
		frame.setBounds(100,100,500,100);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);

		//create the panel and define the layout
		JPanel panel = new JPanel(new GridBagLayout());

		//define layout constraints
		GridBagConstraints c = new GridBagConstraints();
		if(shouldFill){
			//natural height, max width
			c.fill = GridBagConstraints.HORIZONTAL;
			//c.gridwidth = 5;
		}

		//add the panel to the frame
		frame.add(panel);

		/*
		 
		//create empty space
		Box box1 = new Box(0);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(box1, c);
		
		*/
		
		//create label and define its position
		JLabel keyIdLabel = new JLabel("  KeyID: ");
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.2;
		panel.add(keyIdLabel, c);

		//create text field and define its position
		JTextField keyId = new JTextField();
		c.gridx = 3;
		c.gridy = 0;
		c.weightx = 0.8;
		panel.add(keyId, c);

		//create label and define its position
		JLabel vCodeLabel = new JLabel("  vCode: ");
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.2;
		panel.add(vCodeLabel, c);

		//create text field and define its position
		JTextField vCode = new JTextField();
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 0.8;
		panel.add(vCode, c);

		//create button and define its position
		JButton addAcctButton = new JButton("Add Account");
		c.gridx = 3;
		c.gridy = 2;
		c.weightx = 0.3;
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

		addAcctButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				AccountManageWindow.addAcctOpen = false;
				AccountManageWindow.preventClose = false;
				frame.dispose();

			}
		});
	}

}
