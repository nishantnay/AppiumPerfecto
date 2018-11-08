package ePrize.androidMobile.PageObjects;

import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import ePrize.androidMobile.utils.AppiumUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class SamsungGalaxyS3HomePageObjects extends AppiumUtils {
	AppiumUtils utils = new AppiumUtils();

	public SamsungGalaxyS3HomePageObjects() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='Messaging']")
	private MobileElement messageAppIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Compose Button']")
	private MobileElement newMessageIcon;

	@AndroidFindBy(id = "recipients_editor_to")
	private MobileElement enterToMessageNumber;

	@AndroidFindBy(id = "edit_text_bottom")
	private MobileElement enterTextMessage;

	@AndroidFindBy(id = "send_button")
	private MobileElement clickComposebtn;

	@AndroidFindBy(id = "body_text_view")
	private List<MobileElement> responseTextMessage;

	@AndroidFindBy(xpath = "//*[@content-desc='Delete Button']")
	private MobileElement deleteBtn;

	@AndroidFindBy(id = "message_text_select_all")
	private MobileElement selectAllMessages;

	@AndroidFindBy(id = "button1")
	private MobileElement confirmDeletion;
	
	@AndroidFindBy(xpath = "//*[@text='Delete threads']")
	private MobileElement deleteThreadsLink;
	
	@AndroidFindBy(id ="select_all_text")
	private MobileElement AllMessages;

	@Step("Move to the back page using Android key")
	public SamsungGalaxyS3HomePageObjects clickPageBack() throws InterruptedException {
		Reporter.log("Move to the back page using Android key");
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		return this;
	}
	
	
	@Step("click on the delete threads link")
	public SamsungGalaxyS3HomePageObjects deleteThreads() throws InterruptedException {
		Reporter.log("click on the delete threads link");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, deleteThreadsLink);
		Thread.sleep(3000);
		deleteThreadsLink.click();
		return this;
	}

	@Step("click on the delete threads link")
	public SamsungGalaxyS3HomePageObjects selectMessages() throws InterruptedException {
		Reporter.log("click on the delete threads link");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, AllMessages);
		Thread.sleep(3000);
		AllMessages.click();
		System.out.println(driver.getPageSource());
		return this;
	}
	
	@Step("click on the delete button")
	public SamsungGalaxyS3HomePageObjects clickDeleteIcon() throws InterruptedException {
		Reporter.log("click on the delete button");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, deleteBtn);
		Thread.sleep(3000);
		deleteBtn.click();
		return this;
	}

	@Step("click on the delete button")
	public SamsungGalaxyS3HomePageObjects selectAllMessages() throws InterruptedException {
		Reporter.log("click on the delete button");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, selectAllMessages);
		Thread.sleep(2000);
		selectAllMessages.click();
		return this;
	}

	@Step("click on the confirmation delete button")
	public SamsungGalaxyS3HomePageObjects confirmDeletion() throws InterruptedException {
		Reporter.log("click on the confirmation delete button");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, confirmDeletion);
		System.out.println(driver.getPageSource());
		Thread.sleep(2000);
		confirmDeletion.click();
		return this;
	}

	@Step("Click on the FAQ link on Huggies Magical HomePage")
	public SamsungGalaxyS3HomePageObjects switchMobileHomePage() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
		return this;
	}
	@Step("Click on the Menu of the Mobile application")
	public SamsungGalaxyS3HomePageObjects switchMobileMenu() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_MENU);
		return this;
	}
	@Step("Switch to the native app")
	public SamsungGalaxyS3HomePageObjects switchNativeApp() {
		Reporter.log("Switch to the native app");
		driver.context("NATIVE_APP");
		return this;
	}

	@Step("click on the message icon")
	public SamsungGalaxyS3HomePageObjects clickMessageAppIcon() throws InterruptedException {
		Reporter.log("click on the message icon");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, messageAppIcon);
		Thread.sleep(7000);
		messageAppIcon.click();
		return this;
	}

	@Step("click for sending the new message")
	public SamsungGalaxyS3HomePageObjects clickNewMessageIcon() throws InterruptedException {
		Reporter.log("click for sending the new message");
		// AppiumUtils.waitUntillElementToBeClickable(5, 500, newMessageIcon);
		Thread.sleep(7000);
		newMessageIcon.click();
		return this;
	}

	@Step("Input the shortcode for sending the response")
	public SamsungGalaxyS3HomePageObjects enterMobileNumberSendTextMessage(String shortCode)
			throws InterruptedException {
		Reporter.log("Input the shortcode for sending the response");
		// AppiumUtils.waitUntillElementToBeVisible(5, 500,
		// enterToMessageNumber);
		Thread.sleep(7000);
		utils.sendKeys(enterToMessageNumber, shortCode);
		return this;
	}

	@Step("Input the keyword for sending the request the response")
	public SamsungGalaxyS3HomePageObjects enterTextMessage(String Keyword) throws InterruptedException {
		Reporter.log("Input the shortcode for sending the response");
		// AppiumUtils.waitUntillElementToBeVisible(5, 500, enterTextMessage);
		Thread.sleep(7000);
		new Actions(driver).doubleClick(enterTextMessage).clickAndHold();
		utils.sendKeys(enterTextMessage, Keyword);
		return this;
	}

	@Step("Input the keyword for sending the request the response")
	public SamsungGalaxyS3HomePageObjects enterStopTextMessage(String Keyword) throws InterruptedException {
		Reporter.log("Input the shortcode for sending the response");
		Thread.sleep(5000);
		new Actions(driver).doubleClick(enterTextMessage).clickAndHold();
		utils.sendKeys(enterTextMessage, Keyword);
		new Actions(driver).doubleClick(enterTextMessage).clickAndHold();
		utils.sendKeys(enterTextMessage, Keyword);
		return this;
	}
	
	
	
	@Step("Input the keyword for sending the request the response")
	public SamsungGalaxyS3HomePageObjects enterInitialTextMessage(String Keyword) throws InterruptedException {
		Reporter.log("Input the shortcode for sending the response");
		Thread.sleep(5000);
		new Actions(driver).doubleClick(enterTextMessage).clickAndHold();
		utils.sendKeys(enterTextMessage, Keyword);
		new Actions(driver).doubleClick(enterTextMessage).clickAndHold();
		utils.sendKeys(enterTextMessage, Keyword);
		return this;
	}

	@Step("click on the compose button")
	public SamsungGalaxyS3HomePageObjects clickComposeSubmitBtn() throws InterruptedException {
		Reporter.log("click on the compose button");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, clickComposebtn);
		Thread.sleep(7000);
		clickComposebtn.click();
		return this;
	}

	@Step("Input the invalid keyword for sending the request the response")
	public SamsungGalaxyS3HomePageObjects verifyReponseInvalidText() throws InterruptedException {
		Reporter.log("Verify the response for the invalid text");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("HelloWorld Alerts: Sorry, but that keyword was not understood.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertNotEquals(actualmsgInvalidText,
				"HelloWorld Alerts: Sorry, but that keyword was not understood.  Please try again, or reply with HELP or AIDE for help.  Msg & Data rates may apply");
		return this;
	}

	@Step("verify the stop response text")
	public SamsungGalaxyS3HomePageObjects verifyStopReponseInvalidText() throws InterruptedException {
		Reporter.log("Verify the response for the stop request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText()
					.contains("HelloWorld Alerts: You've been unsubscribed and will receive no further messages.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"HelloWorld Alerts: You've been unsubscribed and will receive no further messages. Msg&data rates may apply. For questions: 844-298-1160");
		return this;
	}

	@Step("verify the reponse of COOLIE_REVIEW text request")
	public SamsungGalaxyS3HomePageObjects verifyvalidReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the valid keyword request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes: Reply YES to receive recurring msgs hwld.co/QWUl9F Consent not req 4 purch. Msg&DataRatesMayApply");
		return this;
	}

	@Step("verify the reponse of YES text request")
	public SamsungGalaxyS3HomePageObjects verifyYesReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the YES request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("Please try again. Reply with your 8-digit date of birth (e.g. 01021996).")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"Please try again. Reply with your 8-digit date of birth (e.g. 01021996). 1msg/query. Msg&Data rates may apply. Text STOP to cancel, HELP for help.");
		return this;
	}

	@Step("verify the reponse of VALID Date of birth text request")
	public SamsungGalaxyS3HomePageObjects verifyValidDobReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the DOB request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText()
					.contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE: Please reply with your state (ex: MI).")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE: Please reply with your state (ex: MI). 1msg/query. Rules: http://hwld.co/QWUl9F Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of VALID state text request")
	public SamsungGalaxyS3HomePageObjects verifyValidStateReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the valid state request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("You're in! You earned an entry")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"You're in! You earned an entry and a chance to win in the BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes. Text STOP or HELP.");
		return this;
	}

	@Step("verify the reponse of valid HELP text request")
	public SamsungGalaxyS3HomePageObjects verifyHelpReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the help state request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes Rules:")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes Rules: http://hwld.co/QWUl9F or email questions@helloworldfulfillment.com. Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of valid STOP text request")
	public SamsungGalaxyS3HomePageObjects verifystopReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the STOP state request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("You opted out & will no longer receive messages from this sweepstakes.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"You opted out & will no longer receive messages from this sweepstakes. Msg freq varies by usage. Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of valid STOPALL text request")
	public SamsungGalaxyS3HomePageObjects verifystopAllReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the STOPALL state request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText()
					.contains("HelloWorld Alerts: You've been unsubscribed and will receive no further messages.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"HelloWorld Alerts: You've been unsubscribed and will receive no further messages. Msg&data rates may apply. For questions: 844-298-1160");
		return this;
	}

	@Step("verify the reponse of invalid Dateofbirth text request")
	public SamsungGalaxyS3HomePageObjects verifyinvalidReponseText() throws InterruptedException {
		Reporter.log("Verify the invalid response for the Dateofbirth request");
		Thread.sleep(9000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("Sorry but you're not eligible to participate.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(9000);
		Assert.assertEquals(actualmsgInvalidText,
				"Sorry but you're not eligible to participate. Rules: http://hwld.co/QWUl9F. 1msg/query. Msg&Data rates may apply. Text STOP to cancel, HELP for help.");
		return this;
	}

}
