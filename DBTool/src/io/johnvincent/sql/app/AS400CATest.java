
package io.johnvincent.sql.app;

import org.apache.commons.lang.time.StopWatch;

import io.johnvincent.sql.lib.DB;
import io.johnvincent.sql.lib.DBQuery;

/**
 * Test AS400CA Box
 */
public class AS400CATest {

	private DB m_db;
	public AS400CATest() {}

	public void doWork() {
		System.out.println("Connecting to database");
		m_db = new DB("c:/jv/utils/dbtoolgui.xml");
		if (! m_db.getConnection ("as400CA")) {
			System.out.println("giving up...");
			System.exit(1);
		}
		doTest4();

		System.out.println("Disconnecting from database");
		m_db.disConnect();
		System.out.println("exiting...");
	}
	private void doTest4() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNonNarpAccountInfo("2821787");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}
	private DBQuery getNonNarpAccountInfo(String account) {
		String sql = "select cmname, cmadr1, cmadr2, cmcity, cmstat, cmzip, cmlidt from CUSMASFL " 
				+ " where CMCMP = 'CR' and CMCUS# = " + account;
		DBQuery dbQuery = new DBQuery (m_db, sql);
		dbQuery.executeQuery();
		return dbQuery;
	}

	@SuppressWarnings("unused")
	private DBQuery getNarpAccountNumberForSubAccount(String account) {//2387138, and returned NARP 9231004
		String sql = "select CMCRP# from CUSMASFL where CMCMP = 'CR' and CMCUS# = " + account;
		DBQuery dbQuery = new DBQuery (m_db, sql);
		dbQuery.executeQuery();
		return dbQuery;
	}
	@SuppressWarnings("unused")
	private DBQuery getNarpAccountDetails(String narpAccount) {//9231004
		String sql = "select cmname, cmadr1, cmadr2, cmcity, cmstat, cmzip, cmlidt " 
				+ " from CUSMASFL where  CMCMP = 'CR' and CMCRP# = " + narpAccount + " and CMCUS# = CMCRP#";
		DBQuery dbQuery = new DBQuery (m_db, sql);
		dbQuery.executeQuery();
		return dbQuery;
	}
	@SuppressWarnings("unused")	
	private DBQuery getSubAccountsUnderNarp(String narpAccount) {//9231004
		String sql = "select CMCUS#, cmname, cmadr1, cmadr2, cmcity, cmstat, cmzip, cmlidt from " 
				+ " CUSMASFL  where  CMCMP = 'CR' and CMCRP# = " + narpAccount + " order by CMCUS# ";
		DBQuery dbQuery = new DBQuery (m_db, sql);
		dbQuery.executeQuery();
		return dbQuery;
	}
}
