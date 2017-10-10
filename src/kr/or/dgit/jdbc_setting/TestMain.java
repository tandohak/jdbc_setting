package kr.or.dgit.jdbc_setting;

import java.sql.Connection;

import kr.or.dgit.jdbc_setting.jdbc.DBCon;
import kr.or.dgit.jdbc_setting.jdbc.JdbcUtill;
import kr.or.dgit.jdbc_setting.servise.DbServise;
import kr.or.dgit.jdbc_setting.servise.InitService;

public class TestMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance();		
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		DbServise servise = InitService.getInstance();
		servise.service();
		
		JdbcUtill.close(connection);
	}

}
