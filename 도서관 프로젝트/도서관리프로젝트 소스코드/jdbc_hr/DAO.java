package com.blue.jdbc_hr;

/*
import blue.util.Util;
import java.sql.*;
import java.util.*;
*/
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import com.ict.jdbc_hr.EmpVO;
import jdbc.util.DBUtil;
import javax.swing.*;
public class DAO extends DAOBase{

	public int insertBL(VO vo) {
		try {
			con = DBUtil.getCon();
			String sql = "INSERT INTO BOOKLIST(bno, btitle, writer)"
					+ " VALUES(bl_seq.nextval, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getBtitle());
			ps.setString(2, vo.getWriter());
			int n = ps.executeUpdate();
			return n; 
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}//-----------------
	
	public List<VO> listBL() {
		try {
			con = DBUtil.getCon();
			String sql = "SELECT BNO, BTITLE, WRITER from BOOKLIST ORDER BY bno desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<VO> arr = new ArrayList<>();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String btitle = rs.getString("btitle");
				String writer = rs.getString("writer");
				System.out.println(btitle+"==="+writer);
				VO booklist = new VO(bno, btitle, writer);
				arr.add(booklist);
			}
			System.out.println(arr.size());
			return arr;
			} catch (SQLException e) {
				e.printStackTrace();
				return null; 
			} finally {
				close();
			}
		}//-------------

	/** Delete*/
	public int deleteBL(int bno) {
		try {
			con = DBUtil.getCon();
			String sql = "delete from booklist where bno=?";
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
	}// --------------
	
	/*
	public int updateBL(VO bl) {
		try {
			con = Util.getCon();
			String sql = "UPDATE booklist SET bno = ? , job = ?, deptno = ("
					+ " SELECT deptno FROM dept WHERE dname = ?)"
					+ " WHERE empno = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, bl.getBno());
			ps.setString(2, bl.getBtitle());
			ps.setString(3, bl.getWriter());
			ps.setString(4, bl.getBorrow());
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
    */
}
