package com.blue.jdbc_hr;
import java.sql.*;

import jdbc.util.DBUtil;
import java.util.*;

public class BMDAO extends DAOBase {
	
	// C (Create) : Insert��
	/** ���������� ����ϴ� �޼ҵ�
	 * Insert/Update
	 * Delete
	 */
	BMPanel bmP;
	BMVO vo;
	
	public int insertBM(BMVO vo) {
		try {
			con = DBUtil.getCon();
			// insert�� �ۼ� => ps��� => execute() => ��ȯ�ϱ�
			String sql = "insert into booklist (bno, btitle, writer, borrow) values("
					+" bl_seq.nextval, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getbtitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getBorrow());
			
			int n = ps.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}//---------------------------------------------
	
	// R(Read): ��ȸ - select�� ����
	/*
	 *��� ���������� �������� �޼ҵ� 
	 */
	public java.util.List<BMVO> listBook(){
		try {
			con = DBUtil.getCon();
			String sql = "SELECT BNO, BTITLE, WRITER, BORROW FROM BOOKLIST ORDER BY BNO";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<BMVO> arr = new ArrayList<>();
			while(rs.next()) {
				int bno = rs.getInt(1);
				String btitle = rs.getString(2);
				String writer = rs.getString(3);
				String borrow = rs.getString(4);
				System.out.println(bno + "\t" + btitle + "\t" + writer + "\t" + borrow);
				BMVO record = new BMVO(bno, btitle, writer, borrow);
				arr.add(record);
			}
			return arr;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	
	/** D : ���� - Delete�� ����
	  */
	public int deleteBook(int bno) {
		try {
			con = DBUtil.getCon();
			String sql = "DELETE FROM BOOKLIST WHERE BNO = ?"; //Delete�� 
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
	
	// R(Read): ��ȸ - select�� ����
			/*
			 *������ ���������� �������� �޼ҵ� 
			 */
		public java.util.List<BMVO> searchBook(String bTitle){
			
			try {
				con = DBUtil.getCon();
				String sql = "SELECT BNO, BTITLE, WRITER, BORROW FROM BOOKLIST"
						+ " where BTITLE like ? ORDER BY BNO";
				ps = con.prepareStatement(sql);
				ps.setString(1, "%"+bTitle+"%");
				rs = ps.executeQuery();
				
				List<BMVO> arr = new ArrayList<>();
				while(rs.next()) {
					int bno = rs.getInt(1);
					String btitle = rs.getString(2);
					String writer = rs.getString(3);
					String borrow = rs.getString(4);
					BMVO record = new BMVO(bno, btitle, writer, borrow);
					arr.add(record);
				}
				return arr;
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				close();
			}
		}
	
	/**U - Update
	 *  å��ȣ�� å ������¸� �����ϴ� �޼ҵ�*/
	public int updateBM(BMVO bm) {
		try {
			con = DBUtil.getCon();
			String sql = "UPDATE booklist SET borrow = ?"
					+ " WHERE bno = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, bm.getBorrow());
			ps.setInt(2, bm.getBno());
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
	
}
