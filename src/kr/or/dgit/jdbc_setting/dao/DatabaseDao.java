package kr.or.dgit.jdbc_setting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.dgit.jdbc_setting.jdbc.DBCon;
import kr.or.dgit.jdbc_setting.jdbc.JdbcUtill;

public class DatabaseDao {
	private static final DatabaseDao instance = new DatabaseDao();

	public static DatabaseDao getInstance() {
		return instance;
	}
	
	private DatabaseDao(){}
	
	public void executeUdateSQL(String sql){
		Connection con = DBCon.getInstance().getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}finally {
			JdbcUtill.close(pstmt);
		}
	}
	
	public ResultSet excuteQuerySQL(String sql) throws SQLException{
		Connection con = DBCon.getInstance().getConnection();
		PreparedStatement pstmt = null;		
		return pstmt.executeQuery();
	}
}
