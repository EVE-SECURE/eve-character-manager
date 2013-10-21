package net.mcg_server.ecm.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
		frame.setBounds(250,200,400,180);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);

		//create the panel and define the layout
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//add the panel to the frame
		frame.add(panel);

		//create label and define its position
		JLabel keyIdLabel = new JLabel("  KeyID: ");
		panel.add(keyIdLabel);

		//create text field and define its position
		JTextField keyId = new JTextField();
		panel.add(keyId);

		//create label and define its position
		JLabel vCodeLabel = new JLabel("  vCode: ");
		panel.add(vCodeLabel);

		//create text field and define its position
		JTextField vCode = new JTextField();
		panel.add(vCode);

		//create button and define its position
		JButton addAcctButton = new JButton("Add Account");
		panel.add(addAcctButton);
		
		
		// CREATE INSETS
		Insets insets = panel.getInsets();
		Border bGrayLine = BorderFactory.createLineBorder(Color.GRAY);
		
		Dimension size = keyIdLabel.getPreferredSize();
		keyIdLabel.setBounds(30+insets.left, 20+insets.top, size.width, size.height);
		
		size = keyId.getPreferredSize();
		keyId.setBounds(100+insets.left, 20+insets.top, 250, 20);
		keyId.setBorder(bGrayLine);
		
		size = vCodeLabel.getPreferredSize();
		vCodeLabel.setBounds(30+insets.left, 50+insets.top, size.width, size.height);
		
		size = vCode.getPreferredSize();
		vCode.setBounds(100+insets.left, 50+insets.top, 250, 50);
		vCode.setBorder(bGrayLine);
		
		size = addAcctButton.getPreferredSize();
		addAcctButton.setBounds(150+insets.left, 113+insets.top, 150, size.height);
		


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
