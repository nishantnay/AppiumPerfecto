package ePrize.androidMobile.PageObjects;

import java.sql.SQLException;

import org.testng.Reporter;

import ePrize.androidMobile.utils.DataBaseUtils;
import ru.yandex.qatools.allure.annotations.Step;


public class DataBaseObjects {
	@Step("Disconnect from the database")
	public DataBaseObjects disconnect() throws Exception {
		Reporter.log("Disconnect from the database");
		try {
			DataBaseUtils.dbDisconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this;
	}
	
    @Step("Verifying the profilesId's for registrations,dpv_coordinates,plays,prenormalized_addresses,profiles_fixed_answers,sweeps_entries,tokens,wins tables for Win scenario")
    public DataBaseObjects verifyProfileIdOLAP(String mobilenumber) throws SQLException, ClassNotFoundException, InterruptedException {
        Reporter.log(
                "Verifying the profilesId's for registrations,dpv_coordinates,plays,prenormalized_addresses,profiles_fixed_answers,sweeps_entries,tokens,wins tables for Win scenario");
        Thread.sleep(9000);
        DataBaseUtils.verifyProfileIDOLAP(mobilenumber);
//        return this;
		return null;
    }

	 @Step("Verifying the event name Register in sweeps entry table in OLAP database")
	    public DataBaseObjects verifyEventNameRegisterInSweepEntriesOLAP(String email,String eventName)
	            throws SQLException, ClassNotFoundException, InterruptedException {
	        Reporter.log("Verifying the event name Register in sweeps entry table in OLAP database");
	        Thread.sleep(9000);
	        DataBaseUtils.verifyEventNameRegisterInSweepEntries(email,eventName);
	        return this;
	    }
	
	@Step("Delete the record from OLAP database")
	public DataBaseObjects deleteRecordfromOLAPDataBase(String mobilenumber) throws InterruptedException {
		Reporter.log("Delete the record present in the OLAP database");
		Thread.sleep(9000);
		DataBaseUtils.deleteRecordfromOLAPLooseScenario(mobilenumber);
		return this;
	}
	
	@Step("Delete the record from OLTP database")
	public DataBaseObjects deleteRecordfromOLTPDataBase(String email) throws InterruptedException {
		Reporter.log("Delete the record present in the OLTP database");
		Thread.sleep(9000);
		DataBaseUtils.deleteRecordfromOLTP(email);
		return this;
	}
}