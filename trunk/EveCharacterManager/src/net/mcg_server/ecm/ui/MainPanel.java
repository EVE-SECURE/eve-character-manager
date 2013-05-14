package net.mcg_server.ecm.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel{

	public MainPanel(){

		JLabel label1 = new JLabel("Main Panel");
		this.add(label1);

		JLabel jVerLabel = new JLabel(System.getProperty("java.version"));
		this.add(jVerLabel);
	}
	
}
