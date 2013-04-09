package net.mcg_server.ecm.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddAccountWindow {

	JFrame frame;
	final static boolean shouldFill = true;

	public AddAccountWindow(){
		initialize();
		frame.setVisible(true);
	}

	private void initialize(){
		frame = new JFrame("Add Account");
		frame.setBounds(100,100,400,300);
		JPanel panel = new JPanel(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		if(shouldFill){
			//natural height, max width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		frame.add(panel);

		JLabel keyIdLabel = new JLabel("KeyID: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.3;
		c.ipady = 1;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(keyIdLabel, c);

		JTextField keyId = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.ipady = 1;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(keyId, c);

		JLabel vCodeLabel = new JLabel("\n \nvCode: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.3;
		c.ipady = 1;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(vCodeLabel, c);

		JTextField vCode = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.7;
		c.ipady = 1;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(vCode, c);
	}

}
