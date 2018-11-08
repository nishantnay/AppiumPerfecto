package ePrize.androidMobile.PageObjects;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.Keys;
import ePrize.androidMobile.utils.AppiumUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class SamsungGalaxyS9HomePageObjects extends AppiumUtils {

	AppiumUtils utils = new AppiumUtils();

	public SamsungGalaxyS9HomePageObjects() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='Messages']")
	private MobileElement messageAppIcon;

	@AndroidFindBy(id = "fab")
	private MobileElement newMessageIcon;

	@AndroidFindBy(id = "custom_search_box")
	private MobileElement searchBox;

	@AndroidFindBy(id = "add_tocontact_text_view")
	private MobileElement addDropDown;

	@AndroidFindBy(id = "picker_start_button")
	private MobileElement startButton;

	@AndroidFindBy(id = "recipients_editor_to")
	private MobileElement enterToMessageNumber;

	@AndroidFindBy(xpath = "//*[@text='Enter message']")
	private MobileElement enterTextMessage;

	@AndroidFindBy(id = "send_button1")
	private MobileElement clickComposebtn;

	@AndroidFindBy(id = "content_text_view")
	private List<MobileElement> responseTextMessage;

	@AndroidFindBy(id = "composer_setting_button")
	private MobileElement clickSettingIcon;

	@AndroidFindBy(id = "composer_settings_delete_button")
	private MobileElement clickDeleteIcon;

	@AndroidFindBy(id = "button1")
	private MobileElement confirmDeleteBtn;
	
	@AndroidFindBy(id ="search_src_text")
	private MobileElement searchMessage;
	
	@AndroidFindBy(id ="search_name")
	private List<MobileElement> verifySearchMessage;
	
	@Step("Verify the record exists")
	public SamsungGalaxyS9HomePageObjects verifyRecordExists() throws InterruptedException {
		Reporter.log("Verify the record exists");
		Thread.sleep(3000);
		System.out.println(driver.getPageSource());
		for (MobileElement str : verifySearchMessage) {
			if (str.getText().equals("30364")) {
				str.click();
				clickSettingIcon();
				clickDeleteIcon();
				confirmDeleteButton();
				break;
			} 
		}
		return this;
	}
	
	@Step("Move to the back page using Android key")
	public SamsungGalaxyS9HomePageObjects clickPageBack() throws InterruptedException {
		Reporter.log("Move to the back page using Android key");
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		return this;
	}
	
	
	
	@Step("Input the shortcode for Message")
	public SamsungGalaxyS9HomePageObjects searchMessage(String shortCode)
			throws InterruptedException {
		Reporter.log("Input the shortcode for Message");
		AppiumUtils.waitUntillElementToBeVisible(5, 500, searchMessage);
		Thread.sleep(3000);
		utils.sendKeys(searchMessage, shortCode);
		return this;
	}
	

	@Step("Click on delete icon for deleting specific message")
	public SamsungGalaxyS9HomePageObjects clickSettingIcon() {
		AppiumUtils.waitUntillElementToBeClickable(5, 500, clickSettingIcon);
		clickSettingIcon.click();
		return this;
	}

	@Step("Click on delete icon")
	public SamsungGalaxyS9HomePageObjects clickDeleteIcon() {
		AppiumUtils.waitUntillElementToBeClickable(5, 500, clickDeleteIcon);
		clickDeleteIcon.click();
		return this;
	}

	@Step("Click on delete icon")
	public SamsungGalaxyS9HomePageObjects confirmDeleteButton() {
		AppiumUtils.waitUntillElementToBeClickable(5, 500, confirmDeleteBtn);
		confirmDeleteBtn.click();
		return this;
	}

	@Step("Click on the FAQ link on Huggies Magical HomePage")
	public SamsungGalaxyS9HomePageObjects switchMobileHomePage() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
		return this;
	}

	@Step("Switch to the native app")
	public SamsungGalaxyS9HomePageObjects switchNativeApp() {
		Reporter.log("Switch to the native app");
		driver.context("NATIVE_APP");
		return this;
	}

	@Step("click on the message icon")
	public SamsungGalaxyS9HomePageObjects clickMessageAppIcon() throws InterruptedException {
		Reporter.log("click on the message icon");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, messageAppIcon);
		Thread.sleep(5000);
		messageAppIcon.click();
		return this;
	}

	@Step("click for sending the new message")
	public SamsungGalaxyS9HomePageObjects clickNewMessageIcon() throws InterruptedException {
		Reporter.log("click for sending the new message");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, newMessageIcon);
		Thread.sleep(3000);
		newMessageIcon.click();
		return this;
	}

	@Step("Input the shortcode for sending the response")
	public SamsungGalaxyS9HomePageObjects enterMobileNumberSendTextMessage(String shortCode)
			throws InterruptedException {
		Reporter.log("Input the shortcode for sending the response");
		AppiumUtils.waitUntillElementToBeVisible(5, 500, searchBox);
		Thread.sleep(3000);
		utils.sendKeys(searchBox, shortCode);
		return this;
	}

	@Step("click for sending the new message")
	public SamsungGalaxyS9HomePageObjects addDropDown() throws InterruptedException {
		Reporter.log("click for sending the new message");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, addDropDown);
		Thread.sleep(3000);
		addDropDown.click();
		return this;
	}

	@Step("click for sending the new message")
	public SamsungGalaxyS9HomePageObjects startButton() throws InterruptedException {
		Reporter.log("click for sending the new message");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, startButton);
		Thread.sleep(3000);
		startButton.click();
		return this;
	}

	@Step("Input the keyword for sending the request the response")
	public SamsungGalaxyS9HomePageObjects enterTextMessage(String Keyword) throws InterruptedException {
		Reporter.log("ssss");
		AppiumUtils.waitUntillElementToBeVisible(5, 500, enterTextMessage);
		Thread.sleep(3000);
		enterTextMessage.click();
		utils.sendKeys(enterTextMessage, Keyword);
		System.out.println(driver.getPageSource());
		return this;
	}

	@Step("click on the compose button")
	public SamsungGalaxyS9HomePageObjects clickComposeSubmitBtn() throws InterruptedException {
		Reporter.log("click on the compose button");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, clickComposebtn);
		Thread.sleep(5000);
		clickComposebtn.click();
		return this;
	}

	@Step("Input the invalid keyword for sending the request the response")
	public SamsungGalaxyS9HomePageObjects verifyReponseInvalidText() throws InterruptedException {
		Reporter.log("Verify the response for the invalid text");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("HelloWorld Alerts: Sorry, but that keyword was not understood.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertNotEquals(actualmsgInvalidText,
				"HelloWorld Alerts: Sorry, but that keyword was not understood.  Please try again, or reply with HELP or AIDE for help.  Msg & Data rates may apply");
		return this;
	}

	@Step("verify the stop response text")
	public SamsungGalaxyS9HomePageObjects verifyStopReponseInvalidText() throws InterruptedException {
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
	public SamsungGalaxyS9HomePageObjects verifyvalidReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the valid keyword request");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes: Reply YES")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes: Reply YES to receive recurring msgs hwld.co/QWUl9F Consent not req 4 purch. Msg&DataRatesMayApply");
		return this;
	}

	@Step("verify the reponse of YES text request")
	public SamsungGalaxyS9HomePageObjects verifyYesReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the YES request");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("Please try again. Reply with your 8-digit date of birth (e.g. 01021996).")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertEquals(actualmsgInvalidText,
				"Please try again. Reply with your 8-digit date of birth (e.g. 01021996). 1msg/query. Msg&Data rates may apply. Text STOP to cancel, HELP for help.");
		return this;
	}

	@Step("verify the reponse of VALID Date of birth text request")
	public SamsungGalaxyS9HomePageObjects verifyValidDobReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the DOB request");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText()
					.contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE: Please reply with your state (ex: MI).")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE: Please reply with your state (ex: MI). 1msg/query. Rules: http://hwld.co/QWUl9F Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of VALID state text request")
	public SamsungGalaxyS9HomePageObjects verifyValidStateReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the valid state request");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("You're in! You earned an entry")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertEquals(actualmsgInvalidText,
				"You're in! You earned an entry and a chance to win in the BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes. Text STOP or HELP.");
		return this;
	}

	@Step("verify the reponse of valid HELP text request")
	public SamsungGalaxyS9HomePageObjects verifyHelpReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the help state request");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes Rules:")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertEquals(actualmsgInvalidText,
				"BUDWEISER & BUD LIGHT BASEBALL COOLIE Sweepstakes Rules: http://hwld.co/QWUl9F or email questions@helloworldfulfillment.com. Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of valid STOP text request")
	public SamsungGalaxyS9HomePageObjects verifystopReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the STOP state request");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("You opted out & will no longer receive messages from this sweepstakes.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertEquals(actualmsgInvalidText,
				"You opted out & will no longer receive messages from this sweepstakes. Msg freq varies by usage. Msg&Data rates may apply.");
		return this;
	}

	@Step("verify the reponse of valid STOPALL text request")
	public SamsungGalaxyS9HomePageObjects verifystopAllReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the STOPALL state request");
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

	@Step("verify the reponse of invalid Dateofbirth text request")
	public SamsungGalaxyS9HomePageObjects verifyinvalidReponseText() throws InterruptedException {
		Reporter.log("Verify the invalid response for the Dateofbirth request");
		Thread.sleep(7000);
		String actualmsgInvalidText = "";
		for (MobileElement str : responseTextMessage) {
			if (str.getText().contains("Sorry but you're not eligible to participate.")) {
				actualmsgInvalidText = str.getText();
				break;
			}
		}
		Thread.sleep(7000);
		Assert.assertEquals(actualmsgInvalidText,
				"Sorry but you're not eligible to participate. Rules: http://hwld.co/QWUl9F. 1msg/query. Msg&Data rates may apply. Text STOP to cancel, HELP for help.");
		return this;
	}
}
