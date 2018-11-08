package ePrize.androidMobile.SMSTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ePrize.androidMobile.PageObjects.DataBaseObjects;
import ePrize.androidMobile.PageObjects.MotorolaUltraAndroidHomePageObjects;
import ePrize.androidMobile.utils.AppiumUtils;
import ePrize.androidMobile.utils.DataBaseUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Description;

/**
 * MotorolaUltraAndroidSMSTest class used to test the SMS flow for valid request
 * and response
 */
public class MotorolaUltraAndroidSMSTest {
	MotorolaUltraAndroidHomePageObjects motorolaUltraAndroidHomePageObjects;
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

		motorolaUltraAndroidHomePageObjects.switchMobileHomePage();
		motorolaUltraAndroidHomePageObjects.switchNativeApp();
		motorolaUltraAndroidHomePageObjects.clickMessageAppIcon();
		motorolaUltraAndroidHomePageObjects.clickNewMessageIcon();

		motorolaUltraAndroidHomePageObjects.enterMobileNumberSendTextMessage(shortCode);

		motorolaUltraAndroidHomePageObjects.enterTextMessage(validRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyvalidReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(doubleOptinMessage);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		/*motorolaUltraAndroidHomePageObjects.verifyYesReponseText();*/

		motorolaUltraAndroidHomePageObjects.enterTextMessage(validDOBRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyValidDobReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(validStateRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyValidStateReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(helpRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyHelpReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(stopRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifystopReponseText();

		DataBaseUtils.dbConnectOLAP(jdbcDriverName, dataBaseUrlOLAP, olapDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLAPLooseScenario(mobilenumber);
		DataBaseUtils.dbDisconnect();
		DataBaseUtils.dbConnectOLTP(jdbcDriverName, dataBaseUrlOLTP, oltpDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLTP(mobilenumber);
		DataBaseUtils.dbDisconnect();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(validRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyvalidReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(doubleOptinMessage);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		/*motorolaUltraAndroidHomePageObjects.verifyYesReponseText();*/

		motorolaUltraAndroidHomePageObjects.enterTextMessage(invalidDOBRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyinvalidReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(stopRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyStopReponseInvalidText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(validRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyvalidReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(doubleOptinMessage);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
	    /*motorolaUltraAndroidHomePageObjects.verifyYesReponseText();*/

		motorolaUltraAndroidHomePageObjects.enterTextMessage(validDOBRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyValidDobReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(invalidStateRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifyinvalidReponseText();

		motorolaUltraAndroidHomePageObjects.enterTextMessage(stopRequest);
		motorolaUltraAndroidHomePageObjects.clickComposeSubmitBtn();
		motorolaUltraAndroidHomePageObjects.verifystopReponseText();

	}

	@Parameters({ "deviceID" })
	@BeforeTest
	public void beforeTest(String deviceID) throws IOException, InterruptedException {
		driver = AppiumUtils.getAppiumDriver(deviceID);
		motorolaUltraAndroidHomePageObjects = new MotorolaUltraAndroidHomePageObjects();
		dataBaseObjects = new DataBaseObjects();
	}

	@Parameters({ "deviceID" })
	@AfterTest
	public void afterTest(String deviceID) throws IOException, InterruptedException {
		motorolaUltraAndroidHomePageObjects.clickMoreOptions();
		motorolaUltraAndroidHomePageObjects.clickDeleteLink();
		motorolaUltraAndroidHomePageObjects.clickConfirmationpopup();
		driver.quit();
	}
}