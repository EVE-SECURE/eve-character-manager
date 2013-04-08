package net.mcg_server.ecm.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AccountManageWindow {
	
	JFrame frame;
	
	public AccountManageWindow(){
		initialize();
		frame.setVisible(true);
	}

	private void initialize(){
		frame = new JFrame("Account Management");
		frame.setBounds(100,100,400,300);
		JPanel panel = new JPanel();
		
		frame.add(panel);
		
		JTextArea description = new JTextArea("This is where the page description goes \n"+
					"More Text here using \\n. \n");
		panel.add(description);
		
		JLabel keyIdLabel = new JLabel("KeyID: ");
		panel.add(keyIdLabel);
		
		JTextField keyId = new JTextField();
		panel.add(keyId);
		
		JLabel vCodeLabel = new JLabel("\n \nvCode: ");
		panel.add(vCodeLabel);
		
		JTextField vCode = new JTextField();
		panel.add(vCode);
	}
}
