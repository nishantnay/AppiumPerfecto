package ePrize.androidMobile.SMSTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ePrize.androidMobile.PageObjects.DataBaseObjects;
import ePrize.androidMobile.PageObjects.SamsungGalaxyS9HomePageObjects;
import ePrize.androidMobile.utils.AppiumUtils;
import ePrize.androidMobile.utils.DataBaseUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Description;

/**
 * SamsungGalaxyS9AndroidSmsTest class used to test the SMS flow for valid
 * request and response
 */
public class SamsungGalaxyS9AndroidSMSTest {
	SamsungGalaxyS9HomePageObjects samsungGalaxys9HomePage;
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

		samsungGalaxys9HomePage.switchMobileHomePage();
		samsungGalaxys9HomePage.switchNativeApp();
		samsungGalaxys9HomePage.clickMessageAppIcon();
		samsungGalaxys9HomePage.clickNewMessageIcon();

		samsungGalaxys9HomePage.enterMobileNumberSendTextMessage(shortCode);
		samsungGalaxys9HomePage.addDropDown();
		samsungGalaxys9HomePage.startButton();

		samsungGalaxys9HomePage.enterTextMessage(validRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyvalidReponseText();

		samsungGalaxys9HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		/* samsungGalaxys9HomePage.verifyYesReponseText(); */

		samsungGalaxys9HomePage.enterTextMessage(validDOBRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyValidDobReponseText();

		samsungGalaxys9HomePage.enterTextMessage(validStateRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyValidStateReponseText();

		samsungGalaxys9HomePage.enterTextMessage(helpRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyHelpReponseText();

		samsungGalaxys9HomePage.enterTextMessage(stopRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifystopReponseText();

		DataBaseUtils.dbConnectOLAP(jdbcDriverName, dataBaseUrlOLAP, olapDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLAPLooseScenario(mobilenumber);
		DataBaseUtils.dbDisconnect();
		DataBaseUtils.dbConnectOLTP(jdbcDriverName, dataBaseUrlOLTP, oltpDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLTP(mobilenumber);
		DataBaseUtils.dbDisconnect();

		samsungGalaxys9HomePage.enterTextMessage(validRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyvalidReponseText();

		samsungGalaxys9HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		/* samsungGalaxys9HomePage.verifyYesReponseText(); */

		samsungGalaxys9HomePage.enterTextMessage(invalidDOBRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyinvalidReponseText();

		samsungGalaxys9HomePage.enterTextMessage(stopRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyStopReponseInvalidText();

		samsungGalaxys9HomePage.enterTextMessage(validRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyvalidReponseText();

		samsungGalaxys9HomePage.enterTextMessage(doubleOptinMessage);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		/* samsungGalaxys9HomePage.verifyYesReponseText(); */

		samsungGalaxys9HomePage.enterTextMessage(validDOBRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyValidDobReponseText();

		samsungGalaxys9HomePage.enterTextMessage(invalidStateRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifyinvalidReponseText();

		samsungGalaxys9HomePage.enterTextMessage(stopRequest);
		samsungGalaxys9HomePage.clickComposeSubmitBtn();
		samsungGalaxys9HomePage.verifystopReponseText();

	}

	@Parameters({ "deviceID","shortCode" })
	@BeforeTest
	public void beforeTest(String deviceID,String shortCode) throws IOException, InterruptedException {
		driver = AppiumUtils.getAppiumDriver(deviceID);
		samsungGalaxys9HomePage = new SamsungGalaxyS9HomePageObjects();
		samsungGalaxys9HomePage.switchMobileHomePage();
		samsungGalaxys9HomePage.switchNativeApp();
		samsungGalaxys9HomePage.clickMessageAppIcon();
		samsungGalaxys9HomePage.searchMessage(shortCode);
		samsungGalaxys9HomePage.verifyRecordExists();
		samsungGalaxys9HomePage.clickPageBack();
		dataBaseObjects = new DataBaseObjects();
	}

	@Parameters({ "deviceID" })
	@AfterTest
	public void afterTest(String deviceID) throws IOException {
		samsungGalaxys9HomePage.clickSettingIcon();
		samsungGalaxys9HomePage.clickDeleteIcon();
		samsungGalaxys9HomePage.confirmDeleteButton();
		driver.quit();
	}
}
