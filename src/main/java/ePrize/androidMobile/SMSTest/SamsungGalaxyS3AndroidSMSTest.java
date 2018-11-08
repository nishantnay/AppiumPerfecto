package ePrize.androidMobile.SMSTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ePrize.androidMobile.PageObjects.DataBaseObjects;
import ePrize.androidMobile.PageObjects.SamsungGalaxyS3HomePageObjects;
import ePrize.androidMobile.utils.AppiumUtils;
import ePrize.androidMobile.utils.DataBaseUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Description;

/**
 * SamsungGalaxyS3AndroidSmsTest class used to test the SMS flow for valid
 * request and response
 */
public class SamsungGalaxyS3AndroidSMSTest {
	SamsungGalaxyS3HomePageObjects samsungGalaxys3HomePage;
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

		samsungGalaxys3HomePage.switchMobileHomePage();
		samsungGalaxys3HomePage.switchNativeApp();
		samsungGalaxys3HomePage.clickMessageAppIcon();
		samsungGalaxys3HomePage.clickNewMessageIcon();

		samsungGalaxys3HomePage.enterMobileNumberSendTextMessage(shortCode);

		samsungGalaxys3HomePage.enterInitialTextMessage(validRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyvalidReponseText();

		samsungGalaxys3HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		/* samsungGalaxys3HomePage.verifyYesReponseText(); */

		samsungGalaxys3HomePage.enterTextMessage(validDOBRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyValidDobReponseText();

		samsungGalaxys3HomePage.enterTextMessage(validStateRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyValidStateReponseText();

		samsungGalaxys3HomePage.enterTextMessage(helpRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyHelpReponseText();

		samsungGalaxys3HomePage.enterTextMessage(stopRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifystopReponseText();

		DataBaseUtils.dbConnectOLAP(jdbcDriverName, dataBaseUrlOLAP, olapDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLAPLooseScenario(mobilenumber);
		DataBaseUtils.dbDisconnect();
		DataBaseUtils.dbConnectOLTP(jdbcDriverName, dataBaseUrlOLTP, oltpDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLTP(mobilenumber);
		DataBaseUtils.dbDisconnect();

		samsungGalaxys3HomePage.enterTextMessage(validRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyvalidReponseText();

		samsungGalaxys3HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		/* samsungGalaxys3HomePage.verifyYesReponseText(); */

		samsungGalaxys3HomePage.enterTextMessage(invalidDOBRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyinvalidReponseText();

		samsungGalaxys3HomePage.enterTextMessage(stopRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyStopReponseInvalidText();

		samsungGalaxys3HomePage.enterTextMessage(validRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyvalidReponseText();

		samsungGalaxys3HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		/* samsungGalaxys3HomePage.verifyYesReponseText(); */

		samsungGalaxys3HomePage.enterTextMessage(validDOBRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyValidDobReponseText();

		samsungGalaxys3HomePage.enterTextMessage(invalidStateRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifyinvalidReponseText();

		samsungGalaxys3HomePage.enterTextMessage(stopRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.verifystopReponseText();

	}

	@Parameters({ "deviceID", "stopRequest", "shortCode" })
	@BeforeTest
	public void beforeTest(String deviceID, String stopRequest, String shortCode)
			throws IOException, InterruptedException {
		driver = AppiumUtils.getAppiumDriver(deviceID);
		samsungGalaxys3HomePage = new SamsungGalaxyS3HomePageObjects();
		samsungGalaxys3HomePage.switchMobileHomePage();
		samsungGalaxys3HomePage.switchNativeApp();
		samsungGalaxys3HomePage.clickMessageAppIcon();		
		samsungGalaxys3HomePage.clickPageBack();
		samsungGalaxys3HomePage.switchMobileHomePage();
		samsungGalaxys3HomePage.switchNativeApp();
		samsungGalaxys3HomePage.clickMessageAppIcon();
		samsungGalaxys3HomePage.clickNewMessageIcon();
		samsungGalaxys3HomePage.enterMobileNumberSendTextMessage(shortCode);
		samsungGalaxys3HomePage.enterStopTextMessage(stopRequest);
		samsungGalaxys3HomePage.clickComposeSubmitBtn();
		samsungGalaxys3HomePage.clickDeleteIcon();
		samsungGalaxys3HomePage.selectAllMessages();
		samsungGalaxys3HomePage.clickDeleteIcon();
		samsungGalaxys3HomePage.confirmDeletion();
		dataBaseObjects = new DataBaseObjects();
	}

	@Parameters({ "deviceID" })
	@AfterTest
	public void afterTest(String deviceID) throws IOException, InterruptedException {
		samsungGalaxys3HomePage.clickDeleteIcon();
		samsungGalaxys3HomePage.selectAllMessages();
		samsungGalaxys3HomePage.clickDeleteIcon();
		samsungGalaxys3HomePage.confirmDeletion();
		driver.quit();
	}
}
