package kr.or.dgit.jdbc_setting.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtill {
	public static void close(Connection con){
		//DB 연결 종료를 위한 메소드
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pstmt) {
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
