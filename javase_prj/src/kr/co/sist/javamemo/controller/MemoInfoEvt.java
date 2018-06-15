package kr.co.sist.javamemo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.javamemo.view.MemoInfo;

public class MemoInfoEvt extends WindowAdapter implements ActionListener {
	private MemoInfo mi;
	public MemoInfoEvt(MemoInfo mi){
		this.mi=mi;
	}//constructor
	@Override
	public void windowClosing(WindowEvent we) {
		mi.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mi.dispose();
	}//actionPerformed

}//class
