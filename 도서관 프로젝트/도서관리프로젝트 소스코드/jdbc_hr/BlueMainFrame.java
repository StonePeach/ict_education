package com.blue.jdbc_hr;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;


public class BlueMainFrame extends JFrame {
	JPanel p;
	JTabbedPane tp;
	
	BookRegistrationJPanel brp = new BookRegistrationJPanel();
	BMPanel bmp = new BMPanel();
	MbPanel mbP = new MbPanel();
	
	public BlueMainFrame(){
		super("::BlueMainFrame::");
		Container cp = this.getContentPane();
		
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		p.setLayout(new BorderLayout());
		
		tp = new JTabbedPane();
		p.add(tp);
		
		tp.add(brp, "도서등록");
		tp.add(bmp, "도서관리");
		tp.add(mbP, "회원관리");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	
	public static void main(String[] args) {
		BlueMainFrame my = new BlueMainFrame();
		my.setSize(800, 640);
		my.setVisible(true);

	}

}
