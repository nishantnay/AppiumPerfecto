package ePrize.androidMobile.PageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import ePrize.androidMobile.utils.AppiumUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class MotorolaUltraAndroidHomePageObjects extends AppiumUtils {
	AppiumUtils utils = new AppiumUtils();

	public MotorolaUltraAndroidHomePageObjects() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='Messaging']")
	private MobileElement messageAppIcon;
	@AndroidFindBy(id = "action_compose_new")
	private MobileElement newMessageIcon;
	@AndroidFindBy(id = "recipients_editor")
	private MobileElement enterToMessageNumber;
	@AndroidFindBy(id = "embedded_text_editor")
	private MobileElement enterTextMessage;
	@AndroidFindBy(id = "send_button")
	private MobileElement clickComposebtn;
	@AndroidFindBy(id = "text_view")
	private List<MobileElement> responseTextMessage;
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='More options']")
	private MobileElement clickMoreOptions;
	@AndroidFindBy(xpath = "//*[@text='Delete thread']")
	private MobileElement deleteThread;
	@AndroidFindBy(id = "button1")
	private MobileElement confirmDelete;

	
	@AndroidFindBy(xpath = "//*[@text='Delete all threads']")
	private MobileElement deleteAllThreads;
	
	@Step("click on the deleteAllThreads link")
	public MotorolaUltraAndroidHomePageObjects deleteAllMessagesLink() throws InterruptedException {
		Reporter.log("click on the deleteAllThreads link");
		Thread.sleep(3000);
		deleteAllThreads.click();
		return this;
	}
	
	
	
	@Step("click on the More Optiond icon")
	public MotorolaUltraAndroidHomePageObjects clickMoreOptions() throws InterruptedException {
		Reporter.log("click on the More Optiond icon");
		Thread.sleep(3000);
		clickMoreOptions.click();
		return this;
	}

	@Step("click on the delete thread link")
	public MotorolaUltraAndroidHomePageObjects clickDeleteLink() throws InterruptedException {
		Reporter.log("click on the delete thread link");
		Thread.sleep(3000);
		deleteThread.click();
		return this;
	}

	@Step("click on the delete thread link")
	public MotorolaUltraAndroidHomePageObjects clickConfirmationpopup() throws InterruptedException {
		Reporter.log("click on the confirmation delete button");
		Thread.sleep(3000);
		confirmDelete.click();
		return this;
	}

	@Step("Click on the FAQ link on Huggies Magical HomePage")
	public MotorolaUltraAndroidHomePageObjects switchMobileHomePage() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
		return this;
	}

	@Step("Switch to the native app")
	public MotorolaUltraAndroidHomePageObjects switchNativeApp() {
		Reporter.log("Switch to the native app");
		driver.context("NATIVE_APP");
		return this;
	}

	@Step("click on the message icon")
	public MotorolaUltraAndroidHomePageObjects clickMessageAppIcon() throws InterruptedException {
		Reporter.log("click on the message icon");
		Thread.sleep(5000);
		messageAppIcon.click();
		return this;
	}

	@Step("click for sending the new message")
	public MotorolaUltraAndroidHomePageObjects clickNewMessageIcon() throws InterruptedException {
		Reporter.log("click for sending the new message");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, newMessageIcon);
		Thread.sleep(5000);
		newMessageIcon.click();
		return this;
	}

	@Step("Input the shortcode for sending the response")
	public MotorolaUltraAndroidHomePageObjects enterMobileNumberSendTextMessage(String shortCode)
			throws InterruptedException {
		Reporter.log("Input the shortcode for sending the response");
		AppiumUtils.waitUntillElementToBeVisible(5, 500, enterToMessageNumber);
		Thread.sleep(5000);
		utils.sendKeys(enterToMessageNumber, shortCode);
		return this;
	}

	@Step("Input the keyword for sending the request the response")
	public MotorolaUltraAndroidHomePageObjects enterTextMessage(String Keyword) throws InterruptedException {
		AppiumUtils.waitUntillElementToBeVisible(5, 500, enterTextMessage);
		Thread.sleep(5000);
		utils.sendKeys(enterTextMessage, Keyword);
		return this;
	}

	@Step("click on the compose button")
	public MotorolaUltraAndroidHomePageObjects clickComposeSubmitBtn() throws InterruptedException {
		Reporter.log("click on the compose button");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, clickComposebtn);
		Thread.sleep(5000);
		clickComposebtn.click();
		return this;
	}

	@Step("Input the invalid keyword for sending the request the response")
	public MotorolaUltraAndroidHomePageObjects verifyReponseInvalidText() throws InterruptedException {
		Reporter.log("Verify the response for the invalid text");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("HelloWorld Alerts: Sorry, but that keyword was not understood.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertNotEquals(actualmsgInvalidText,
				"HelloWorld Alerts: Sorry, but that keyword was not understood.  Please try again, or reply with HELP or AIDE for help.  Msg & Data rates may apply");
		return this;
	}

	@Step("verify the stop response text")
	public MotorolaUltraAndroidHomePageObjects verifyStopReponseInvalidText() throws InterruptedException {
		Reporter.log("Verify the response for the stop request");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText()
					.contains("HelloWorld Alerts: You've been unsubscribed and will receive no further messages.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertEquals(actualmsgInvalidText,
				"HelloWorld Alerts: You've been unsubscribed and will receive no further messages. Msg&data rates may apply. For questions: 844-298-1160");
		return this;
	}

	@Step("verify the reponse of COOLIE_REVIEW text request")
	public MotorolaUltraAndroidHomePageObjects verifyvalidReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the valid keyword request");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes: Reply YES to receive recurring msgs hwld.co/QWUl9F Consent not req 4 purch. Msg&DataRatesMayApply");
		return this;
	}

	@Step("verify the reponse of YES text request")
	public MotorolaUltraAndroidHomePageObjects verifyYesReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the YES request");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("Please try again. Reply with your 8-digit date of birth (e.g. 01021996).")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertEquals(actualmsgInvalidText,
				"Please try again. Reply with your 8-digit date of birth (e.g. 01021996). 1msg/query. Msg&Data rates may apply. Text STOP to cancel, HELP for help.");
		return this;
	}

	@Step("verify the reponse of VALID Date of birth text request")
	public MotorolaUltraAndroidHomePageObjects verifyValidDobReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the DOB request");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText()
					.contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE: Please reply with your state (ex: MI).")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE: Please reply with your state (ex: MI). 1msg/query. Rules: http://hwld.co/QWUl9F Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of VALID state text request")
	public MotorolaUltraAndroidHomePageObjects verifyValidStateReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the valid state request");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("You're in! You earned an entry")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertEquals(actualmsgInvalidText,
				"You're in! You earned an entry and a chance to win in the BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes. Text STOP or HELP.");
		return this;
	}

	@Step("verify the reponse of valid HELP text request")
	public MotorolaUltraAndroidHomePageObjects verifyHelpReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the help state request");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes Rules:")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes Rules: http://hwld.co/QWUl9F or email questions@helloworldfulfillment.com. Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of valid STOP text request")
	public MotorolaUltraAndroidHomePageObjects verifystopReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the STOP state request");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("You opted out & will no longer receive messages from this sweepstakes.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertEquals(actualmsgInvalidText,
				"You opted out & will no longer receive messages from this sweepstakes. Msg freq varies by usage. Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of valid STOPALL text request")
	public MotorolaUltraAndroidHomePageObjects verifystopAllReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the STOPALL state request");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText()
					.contains("HelloWorld Alerts: You've been unsubscribed and will receive no further messages.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertEquals(actualmsgInvalidText,
				"HelloWorld Alerts: You've been unsubscribed and will receive no further messages. Msg&data rates may apply. For questions: 844-298-1160");
		return this;
	}

	@Step("verify the reponse of invalid Dateofbirth text request")
	public MotorolaUltraAndroidHomePageObjects verifyinvalidReponseText() throws InterruptedException {
		Reporter.log("Verify the invalid response for the Dateofbirth request");
		Thread.sleep(5000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("Sorry but you're not eligible to participate.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(5000);
		Assert.assertEquals(actualmsgInvalidText,
				"Sorry but you're not eligible to participate. Rules: http://hwld.co/QWUl9F. 1msg/query. Msg&Data rates may apply. Text STOP to cancel, HELP for help.");
		return this;
	}

}
