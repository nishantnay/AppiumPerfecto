package ePrize.androidMobile.SMSTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ePrize.androidMobile.PageObjects.DataBaseObjects;
import ePrize.androidMobile.PageObjects.SamsungGalaxyS6HomePageObjects;
import ePrize.androidMobile.utils.AppiumUtils;
import ePrize.androidMobile.utils.DataBaseUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Description;

/**
 * SamsungGalaxyS6AndroidSmsTest class used to test the SMS flow for valid
 * request and response
 */
public class SamsungGalaxyS6AndroidSMSTest {
	SamsungGalaxyS6HomePageObjects samsungGalaxys6HomePage;
	DataBaseObjects dataBaseObjects;
	protected static AndroidDriver<MobileElement> driver;

	@Parameters({ "shortCode", "validRequest", "doubleOptinMessage", "validDOBRequest", "validStateRequest",
			"helpRequest", "stopRequest", "mobilenumber", "olapDatabaseName", "oltpDatabaseName", "jdbcDriverName",
			"dataBaseUrlOLAP", "dataBaseUrlOLTP", "username", "password", "invalidDOBRequest", "invalidStateRequest" })
	@Description("To test sms flow for valid request and response on the Motorola Turbo Device")
	@Test
	public void verifySMSRequestandResponse(String shortCode, String validRequest, String doubleOptinMessage,
			String validDOBRequest, String validStateRequest, String helpRequest, String stopRequest,
			String mobilenumber, String olapDatabaseName, String oltpDatabaseName, String jdbcDriverName,
			String dataBaseUrlOLAP, String dataBaseUrlOLTP, String username, String password, String invalidDOBRequest,
			String invalidStateRequest) throws Exception {

		samsungGalaxys6HomePage.switchMobileHomePage();
		samsungGalaxys6HomePage.switchNativeApp();
		samsungGalaxys6HomePage.clickMessageAppIcon();
		samsungGalaxys6HomePage.clickNewMessageIcon();

		samsungGalaxys6HomePage.enterMobileNumberSendTextMessage(shortCode);

		samsungGalaxys6HomePage.enterTextMessage(validRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyvalidReponseText();

		samsungGalaxys6HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		/*samsungGalaxys6HomePage.verifyYesReponseText();*/

		samsungGalaxys6HomePage.enterTextMessage(validDOBRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyValidDobReponseText();

		samsungGalaxys6HomePage.enterTextMessage(validStateRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyValidStateReponseText();

		samsungGalaxys6HomePage.enterTextMessage(helpRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyHelpReponseText();

		samsungGalaxys6HomePage.enterTextMessage(stopRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifystopReponseText();

		DataBaseUtils.dbConnectOLAP(jdbcDriverName, dataBaseUrlOLAP, olapDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLAPLooseScenario(mobilenumber);
		DataBaseUtils.dbDisconnect();
		DataBaseUtils.dbConnectOLTP(jdbcDriverName, dataBaseUrlOLTP, oltpDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLTP(mobilenumber);
		DataBaseUtils.dbDisconnect();

		samsungGalaxys6HomePage.enterTextMessage(validRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyvalidReponseText();

		samsungGalaxys6HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		/*samsungGalaxys6HomePage.verifyYesReponseText();*/

		samsungGalaxys6HomePage.enterTextMessage(invalidDOBRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyinvalidReponseText();

		samsungGalaxys6HomePage.enterTextMessage(stopRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyStopReponseInvalidText();

		samsungGalaxys6HomePage.enterTextMessage(validRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyvalidReponseText();

		samsungGalaxys6HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		/*samsungGalaxys6HomePage.verifyYesReponseText();*/

		samsungGalaxys6HomePage.enterTextMessage(validDOBRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyValidDobReponseText();

		samsungGalaxys6HomePage.enterTextMessage(invalidStateRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifyinvalidReponseText();

		samsungGalaxys6HomePage.enterTextMessage(stopRequest);
		samsungGalaxys6HomePage.clickComposeSubmitBtn();
		samsungGalaxys6HomePage.verifystopReponseText();

	}

	@Parameters({ "deviceID" })
	@BeforeTest
	public void beforeTest(String deviceID) throws IOException {
		driver = AppiumUtils.getAppiumDriver(deviceID);
		samsungGalaxys6HomePage = new SamsungGalaxyS6HomePageObjects();
		dataBaseObjects = new DataBaseObjects();
	}

	@Parameters({ "deviceID" })
	@AfterTest
	public void afterTest(String deviceID) throws IOException {
		driver.quit();
	}
}
