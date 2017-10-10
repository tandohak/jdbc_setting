package kr.or.dgit.jdbc_setting;

import kr.or.dgit.jdbc_setting.dao.DatabaseDao;
import kr.or.dgit.jdbc_setting.servise.DbService;

public class ImportServise implements DbService {
	private static final ImportServise Instance= new ImportServise();
	@Override
	public void service() {
		
	}
	public static ImportServise getInstance() {
		return Instance;
	}
	
	public ImportServise() {
		DatabaseDao.getInstance().executeUdateSQL("SET FOREIGN_KEY_CHECKS = 0");
		DatabaseDao.getInstance().executeUdateSQL("use " + Config.DB_NAME);
		for (String tableName : Config.TABLE_NAME) {
			DatabaseDao.getInstance().executeUdateSQL(String.format("LOAD DATA LOCAL INFILE '%s' INTO TABLE %s ",	Config.getFilePath(tableName, false), tableName));
		}
		DatabaseDao.getInstance().executeUdateSQL("SET FOREIGN_KEY_CHECKS = 1");
	}
	

}
