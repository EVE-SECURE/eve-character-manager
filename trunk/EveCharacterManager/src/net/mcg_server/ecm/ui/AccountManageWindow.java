package net.mcg_server.ecm.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AccountManageWindow {
	
	JFrame frame;
	
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	
	public AccountManageWindow(){
		initialize();
		frame.setVisible(true);
	}

	private void initialize(){
		frame = new JFrame("Account Management");
		frame.setBounds(100,100,400,150);
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		if(shouldFill){
			//natural height, max width
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		frame.add(panel);
		
		JTextArea description = new JTextArea("This is where the page description goes \n"+
					"More Text here using \\n. \n");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.ipady = 4;
		c.weightx = 0.3;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(description, c);
		
		JButton button = new JButton("Add Account");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 4;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(button, c);
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// open AddAccountWindow
				new AddAccountWindow();
			}
		});
	}
}
