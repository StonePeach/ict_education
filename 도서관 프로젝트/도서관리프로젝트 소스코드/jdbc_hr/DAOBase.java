package com.blue.jdbc_hr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOBase {

	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;

	public void close() {
		try {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}///////////////////////////////////////////////
