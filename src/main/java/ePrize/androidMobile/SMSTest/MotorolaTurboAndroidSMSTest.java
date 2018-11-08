package ePrize.androidMobile.SMSTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ePrize.androidMobile.PageObjects.AndroidMobileHomePageObjects;
import ePrize.androidMobile.PageObjects.DataBaseObjects;
import ePrize.androidMobile.utils.AppiumUtils;
import ePrize.androidMobile.utils.DataBaseUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import ru.yandex.qatools.allure.annotations.Description;

/**
 * MotorolaTurboAndroidSMSTest class used to test the SMS flow for valid request
 * and response
 */
public class MotorolaTurboAndroidSMSTest {
	AndroidMobileHomePageObjects androidMobileHomePage;
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

		androidMobileHomePage.switchMobileHomePage();
		androidMobileHomePage.switchNativeApp();
		androidMobileHomePage.clickMessageAppIcon();
		androidMobileHomePage.clickNewMessageIcon();

		androidMobileHomePage.enterMobileNumberSendTextMessage(shortCode);

		androidMobileHomePage.enterTextMessage(validRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyvalidReponseText();

		androidMobileHomePage.enterTextMessage(doubleOptinMessage);
		androidMobileHomePage.clickComposeSubmitBtn();
		/*androidMobileHomePage.verifyYesReponseText();*/

		androidMobileHomePage.enterTextMessage(validDOBRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyValidDobReponseText();

		androidMobileHomePage.enterTextMessage(validStateRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyValidStateReponseText();

		androidMobileHomePage.enterTextMessage(helpRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyHelpReponseText();

		androidMobileHomePage.enterTextMessage(stopRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifystopReponseText();

		DataBaseUtils.dbConnectOLAP(jdbcDriverName, dataBaseUrlOLAP, olapDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLAPLooseScenario(mobilenumber);
		DataBaseUtils.dbDisconnect();
		DataBaseUtils.dbConnectOLTP(jdbcDriverName, dataBaseUrlOLTP, oltpDatabaseName, username, password);
		DataBaseUtils.deleteRecordfromOLTP(mobilenumber);
		DataBaseUtils.dbDisconnect();

		androidMobileHomePage.enterTextMessage(validRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyvalidReponseText();

		androidMobileHomePage.enterTextMessage(doubleOptinMessage);
		androidMobileHomePage.clickComposeSubmitBtn(); 
		/*androidMobileHomePage.verifyYesReponseText();*/

		androidMobileHomePage.enterTextMessage(invalidDOBRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyinvalidReponseText();

		androidMobileHomePage.enterTextMessage(stopRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyStopReponseInvalidText();

		androidMobileHomePage.enterTextMessage(validRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyvalidReponseText();

		androidMobileHomePage.enterTextMessage(doubleOptinMessage);
		androidMobileHomePage.clickComposeSubmitBtn(); 
		/*androidMobileHomePage.verifyYesReponseText();*/

		androidMobileHomePage.enterTextMessage(validDOBRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyValidDobReponseText();

		androidMobileHomePage.enterTextMessage(invalidStateRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifyinvalidReponseText();

		androidMobileHomePage.enterTextMessage(stopRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.verifystopReponseText();

	}

	@Parameters({ "deviceID","shortCode" })
	@BeforeTest
	public void beforeTest(String deviceID,String shortCode) throws IOException, InterruptedException {
		driver = AppiumUtils.getAppiumDriver(deviceID);
		androidMobileHomePage = new AndroidMobileHomePageObjects();
		androidMobileHomePage.switchMobileHomePage();
		androidMobileHomePage.switchNativeApp();
		androidMobileHomePage.clickMessageAppIcon();
		androidMobileHomePage.clickSearchBtn();
		androidMobileHomePage.searchMobileNumber(shortCode);
		androidMobileHomePage.verifyRecordExists();
		androidMobileHomePage.clickPageBack();
		dataBaseObjects = new DataBaseObjects();
	}

	@Parameters({ "deviceID","stopRequest" })
	@AfterTest
	public void afterTest(String deviceID,String stopRequest) throws IOException, InterruptedException {
		androidMobileHomePage.enterTextMessage(stopRequest);
		androidMobileHomePage.clickComposeSubmitBtn();
		androidMobileHomePage.clickImageGalleryLink();
		androidMobileHomePage.clickDeleteMsgPopupLink();
		androidMobileHomePage.clickSelectAllMsgLink();
		androidMobileHomePage.clickDeleteIconLink();
		androidMobileHomePage.clickConfirmationPopup();
		driver.quit();
	}
}