package kr.co.sist.licensee.controller;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class testDalog extends JDialog {
	ClientTest clientTest;

	public testDalog(ClientTest clientTest) {
		JLabel lblimg=new JLabel(new ImageIcon(clientTest.download()));
		add(lblimg);
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
