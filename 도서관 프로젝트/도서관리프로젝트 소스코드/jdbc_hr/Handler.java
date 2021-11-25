package com.blue.jdbc_hr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class Handler extends MouseAdapter implements ActionListener {
	
	
	private BookRegistrationJPanel blP; // View
	private DAO blDao; // Model


	public Handler(BookRegistrationJPanel brP) {
		this.blP = brP;
		this.blDao = new DAO();
	}
	
	public void clearTf() {
		blP.tfBtitle.setText("");
		blP.tfWriter.setText("");

	}// ---------
	
	public void show(String msg) {
		JOptionPane.showMessageDialog(blP, msg);
	}//----------
	
	public void add() {
		String btitle = blP.tfBtitle.getText();
		String writer = blP.tfWriter.getText();

		if(btitle == null || writer == null || btitle.trim().equals("") || writer.trim().isEmpty()) {
			show("도서명이나 작가를 입력하세요");
			blP.tfBtitle.requestFocus();
			return;
		}
		
		VO vo = new VO(0, btitle, writer);
//		vo.setBno(bno);   // 이부분 물어봐야함!!!!!!!!!!!!!!!!!
//		vo.setBtitle(btitle);
		
		int n = blDao.insertBL(vo);
		
		String msg = (n > 0)? "도서등록 완료" : "도서등록 실패";
		show(msg);
		clearTf();
		if(n > 0) {
			listBL();
		}
	}//------------
	
	public void listBL() {
		java.util.List<VO> arr = blDao.listBL();
		blP.showBLTable(arr);
	}
	/*
	public void list() {
		ArrayList<VO> arr = blDao.listBL();
		if(arr == null) return;
		blP.showBLList(arr);
	}//------------
	*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == blP.btBRAdd) {
			add();
			listBL();
		}else if(obj == blP.btBRList) {
			listBL();
		}else if (obj == blP.btBRReset) {
			clearTf();
		}
	}
}		
		
