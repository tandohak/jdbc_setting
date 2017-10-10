package kr.or.dgit.jdbc_setting;

import java.sql.Connection;

import kr.or.dgit.jdbc_setting.jdbc.DBCon;
import kr.or.dgit.jdbc_setting.jdbc.JdbcUtil;
import kr.or.dgit.jdbc_setting.servise.DbService;
import kr.or.dgit.jdbc_setting.servise.InitService;

public class TestMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance();		
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		DbService servise = InitService.getInstance();
		servise.service();
		
		servise = ImportServise.getInstance();
		servise.service();
		
		servise = ExportService.getInstance();
		servise.service();
		
		JdbcUtil.close(connection);
	}

}
