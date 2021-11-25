package com.blue.jdbc_hr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class MbHandler extends MouseAdapter implements ActionListener {
	private MbPanel mbP; // View
	private MbDAO mbDao; // Model

	public MbHandler(MbPanel mbP) {
		this.mbP = mbP;
		this.mbDao = new MbDAO();
	}

	private void addMb() {
		// 1. 나이, 이름, 주소 가져오기
		String str_year = mbP.tfMyear.getText();
		if (str_year == null || str_year.trim().isEmpty()) {
			show("나이를 입력해야 해요");
			mbP.tfMyear.requestFocus();
			return;
		}

		int m_year = Integer.parseInt(str_year.trim());
		String m_name = mbP.tfMname.getText();
		String m_address = mbP.tfMaddress.getText();

		// 2. 유효성 체크(null, 빈문자열 체크)
		if (m_name == null || m_address == null || m_name.trim().equals("") || m_address.trim().equals("")) {
			show("이름과 주소를 입력해야 해요");
			mbP.tfMyear.requestFocus();
			return;
		}

		// 3. MbVO에 나이, 이름, 주소 담아주기
		MbVO vo = new MbVO();
		vo.setMyear(m_year);
		vo.setMname(m_name);
		vo.setMaddress(m_address);

		// 4. MbDAO의 insertMb()호출하기
		int n = mbDao.insertMb(vo);

		// 5. 그 결과 메시지 처리
		String msg = (n > 0) ? "회원정보 등록 완료" : "회원정보 등록 실패";
		show(msg);
		clearTf();
	}

	private void deleteMb() {
		String str_year = mbP.tfMyear.getText();
		if (str_year == null || str_year.trim().isEmpty()) {
			show("나이를 입력해야 해요");
			mbP.tfMyear.requestFocus();
			return;
		}

		int m_year = Integer.parseInt(str_year.trim());
		String m_name = mbP.tfMname.getText();
		String m_address = mbP.tfMaddress.getText();
		String m_date = mbP.tfMdate.getText();

		// 2. 유효성 체크(null, 빈문자열 체크)
		if (m_name == null || m_address == null || m_name.trim().equals("") || m_address.trim().equals("")) {
			show("이름과 주소를 입력해야 해요");
			mbP.tfMyear.requestFocus();
			return;
		}

		// 3. MbVO에 나이, 이름, 주소, 날짜 담아주기
		MbVO vo = new MbVO();
		vo.setMyear(m_year);
		vo.setMname(m_name);
		vo.setMaddress(m_address);
		vo.setMdateStr(m_date);
		// 4. MbDAO의 insertMb()호출하기
		int n = mbDao.deleteMb(vo);

		// 5. 그 결과 메시지 처리
		String msg = (n > 0) ? "회원정보 삭제 완료" : "회원정보 삭제 실패";
		show(msg);
		clearTf();

	}

	private void updateMb() {
		// 1. 사용자가 수정한 값 가져오기
		String str_year = mbP.tfMyear.getText();
		if (str_year == null || str_year.trim().isEmpty()) {
			show("나이를 입력해야 해요");
			mbP.tfMyear.requestFocus();
			return;
		}

		int m_year = Integer.parseInt(str_year.trim());
		String m_name = mbP.tfMname.getText();
		String m_address = mbP.tfMaddress.getText();
		String m_date = mbP.tfMdate.getText();
		
		// 2. 유효성 체크(null, 빈문자열 체크)
		if (m_name == null || m_address == null || m_name.trim().isEmpty() || m_address.trim().equals("")) {
			show("이름과 주소를 입력해야 해요");
			mbP.tfMyear.requestFocus();
			return;
		}

		// 3. MbVO에 나이, 이름, 주소, 날짜 담아주기
		MbVO vo = new MbVO();
		vo.setMyear(m_year);
		vo.setMname(m_name);
		vo.setMaddress(m_address);
		vo.setMdateStr(m_date);
		
		// 4.MbDao의 updateEmp(vo객체) 호출하기
		int n = mbDao.updateMp(vo);

		// 5. 그 결과 메시지 처리
		String msg = (n > 0) ? "회원정보 수정 완료" : "회원정보 수정 실패";
		show(msg);
		clearTf();
		
	}

	private void show(String msg) {
		JOptionPane.showMessageDialog(mbP, msg);

	}

	private void clearTf() {
		mbP.tfMyear.setText("");
		mbP.tfMname.setText("");
		mbP.tfMaddress.setText("");
		mbP.tfMname.setText("");
	}

	private void listMb() {
		java.util.List<MbVO> arr = mbDao.listMb();
		mbP.showMbTable(arr);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == mbP.btMbAdd) {
			addMb();
			listMb();
		} else if (obj == mbP.btMbDel) {
			deleteMb();
			listMb();
		} else if (obj == mbP.btMbEdit) {
			updateMb();
			listMb();
		} else if (obj == mbP.btMbList) {
			listMb();

		} else if (obj == mbP.btMbReset) {
			clearTf();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		setMbData();
	}

	private void setMbData() {
		int row = mbP.mbTable.getSelectedRow();
		System.out.println("row: " + row);
		if (row < 0)
			return;

		// 해당 행의 데이터 추출
		String myear = mbP.mbModel.getValueAt(row, 0).toString();
		String mname = mbP.mbModel.getValueAt(row, 1).toString();
		String maddress = mbP.mbModel.getValueAt(row, 2).toString();
		String mdate = mbP.mbModel.getValueAt(row, 3).toString();
		
		// 셋팅
		mbP.tfMyear.setText(myear);
		mbP.tfMname.setText(mname);
		mbP.tfMaddress.setText(maddress);
		mbP.tfMdate.setText(mdate);

	}

}///////////////////////////////////////
