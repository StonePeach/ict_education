package com.blue.jdbc_hr;

import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import com.ict.jdbc_hr.EmpVO;
import jdbc.util.DBUtil;
import javax.swing.*;

public class MbDAO extends DAOBase {

	public int insertMb(MbVO vo) {
		try {
			con = DBUtil.getCon();
			String sql = "INSERT INTO member(myear, mname, maddress, mdate, mnumber)" + " VALUES(?, ?, ?, sysdate, seq_num.nextval)";

			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getMyear());
			ps.setString(2, vo.getMname());
			ps.setString(3, vo.getMaddress());
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}

	}

	public int deleteMb(MbVO vo) {
		try {
			System.out.println(vo);
			con = DBUtil.getCon();
			String sql = "DELETE FROM MEMBER WHERE myear=? AND mname=? AND MADDRESS=? AND TO_CHAR(MDATE, 'yyyy-mm-dd')=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getMyear());
			ps.setString(2, vo.getMname());
			ps.setString(3, vo.getMaddress());
			ps.setString(4, vo.getMdateStr());
			int n = ps.executeUpdate();
			System.out.println(n);
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}

	}

	public int updateMp(MbVO vo) {
		JOptionPane J = new JOptionPane();
		try {
			System.out.println(vo);
			con = DBUtil.getCon();
			String sql = "UPDATE MEMBER SET MYEAR = ?, MNAME=?, MADDRESS=?"
					+ " WHERE MNUMBER = ?";
					
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getMyear());
			ps.setString(2, vo.getMname());
			ps.setString(3, vo.getMaddress());
			ps.setString(4, vo.getMdateStr());
			String numstr = J.showInputDialog("수정할 회원번호를 입력하세요.");
			int num = Integer.parseInt(numstr);
			ps.setInt(4, num);
			int n = ps.executeUpdate();
			System.out.println(n);
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}

	}

	/** 모든 사원 정보 가져오는 메소드 */
	public java.util.List<MbVO> listMb() {
		try {
			con = DBUtil.getCon();
			String sql = "SELECT MYEAR, MNAME, MADDRESS, MDATE, MNUMBER FROM MEMBER";
			// 사번, 사원명, 업무, 입사일, 부서번호, 회원번호
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<MbVO> arr = new ArrayList<>();
			while (rs.next()) {
				int myear = rs.getInt("myear");
				String mname = rs.getString("mname");
				String maddress = rs.getString("maddress");
				java.sql.Date mdate = rs.getDate("mdate");
				int mnumber = rs.getInt("mnumber");			
				MbVO mb = new MbVO(myear, mname, maddress, mdate, mnumber);
				arr.add(mb);
			} // while----
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}

	}// ---------------

}
