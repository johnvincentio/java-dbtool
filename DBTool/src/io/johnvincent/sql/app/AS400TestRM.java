
package io.johnvincent.sql.app;

import org.apache.commons.lang.time.StopWatch;

import io.johnvincent.sql.lib.DB;
import io.johnvincent.sql.lib.DBQuery;

/**
* @author John Vincent
*/

public class AS400TestRM {
	private DB m_db;

	public static void main(String[] args) {
		AS400TestRM test = new AS400TestRM();
		test.doWork();
	}

	public void doWork() {
		System.out.println("Connecting to database");
		m_db = new DB("c:/jv/utils/dbtoolgui.xml");
		if (! m_db.getConnection ("as400US")) {
			System.out.println("giving up...");
			System.exit(1);
		}
		doTest4();

		System.out.println("Disconnecting from database");
		m_db.disConnect();
		System.out.println("exiting...");
	}

	@SuppressWarnings("unused")
	private void doTest1() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNarpPart1("4017");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}

	@SuppressWarnings("unused")
	private void doTest2() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNarpPart2("4017");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}

	@SuppressWarnings("unused")
	private void doTest3() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNarpPart3("6003093");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}

	private void doTest4() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNarpPart1("6003093");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}

	@SuppressWarnings("unused")
	private void doTest5() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNarpPart1("7850695");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}
	@SuppressWarnings("unused")
	private void doTest5a() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNarpPart3("7850695");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}

	@SuppressWarnings("unused")
	private void doTest6() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNarpPart1("3093");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}
	@SuppressWarnings("unused")
	private void doTest6a() {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		DBQuery dbQuery = getNarpPart3("3093");
		stopWatch.stop();
		final long millis = stopWatch.getTime();
		System.out.println (dbQuery.reportQuery(millis));
	}
	private DBQuery getNarpPart1(String narp) {
		String sql = "select distinct(b.CMCRP#) from RMHCQDATA.CUSMASFL b, RMHCQDATA.CUSMS2FL a "+
			"where a.CMCMP2 ='HG' and a.CMNATLCON# = "+narp+" and a.CMCMP2 = b.CMCMP and  a.CMCUS#2 = b.CMCUS#";
		DBQuery dbQuery = new DBQuery (m_db, sql);
		dbQuery.executeQuery();
		return dbQuery;
	}
	private DBQuery getNarpPart2(String narp) {
		String sql = "select a.CMCUS#, a.cmname, a.cmadr1, a.cmadr2, a.cmcity, a.cmstat, a.cmzip "+
			"from RMHCQDATA.CUSMS2F2 b, RMHCQDATA.CUSMASFL a "+
			"where b.CMCUS#2 = a.CMCUS# and b.CMCMP2 = 'HG' and b.CMNATLCON# = "+narp+" order by a.CMCMP";
		DBQuery dbQuery = new DBQuery (m_db, sql);
		dbQuery.executeQuery();
		return dbQuery;
	}
	private DBQuery getNarpPart3(String corplink) {
		String sql = "select cmname, cmadr1, cmadr2, cmcity, cmstat, cmzip "+
			"from RMHCQDATA.CUSMASF4 "+
			"where CMCMP = 'HG' and CMCRP# = "+corplink+" and CMCUS# = "+corplink;			// both of these are the corplink
		DBQuery dbQuery = new DBQuery (m_db, sql);
		dbQuery.executeQuery();
		return dbQuery;
	}
}
