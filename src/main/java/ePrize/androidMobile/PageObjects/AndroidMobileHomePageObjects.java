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

public class AndroidMobileHomePageObjects extends AppiumUtils {
	AppiumUtils utils = new AppiumUtils();

	public AndroidMobileHomePageObjects() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[@text='Message+']")
	private MobileElement messageAppIcon;

	@AndroidFindBy(id = "composeFab")
	private MobileElement newMessageIcon;

	@AndroidFindBy(id = "composeMessageList")
	private MobileElement enterToMessageNumber;

	@AndroidFindBy(id = "compose_embedded_text_editor")
	private MobileElement enterTextMessage;

	@AndroidFindBy(id = "composebtnSend")
	private MobileElement clickComposebtn;

	@AndroidFindBy(id = "text")
	private List<MobileElement> responseTextMessage;

	@AndroidFindBy(id = "imgGalleryOption")
	private MobileElement imageGallery;

	@AndroidFindBy(xpath = "//*[@text='Delete Messages']")
	private MobileElement deleteMessages;

	@AndroidFindBy(id = "select_All_conv")
	private MobileElement selectAllMessages;

	@AndroidFindBy(id = "delete_btn")
	private MobileElement deleteIcon;

	@AndroidFindBy(id = "positive_button")
	private MobileElement confirmDeleteMessagePopup;

	@AndroidFindBy(id = "searchbutton")
	private MobileElement searchBtn;

	@AndroidFindBy(id = "searchEdit")
	private MobileElement enterKeyword;

	@AndroidFindBy(id = "title")
	private List<MobileElement> getTitle;

	@AndroidFindBy(id = "recents_closeall_container")
	private MobileElement closeAllApps;
	
	
	@Step("click on the search button icon")
	public AndroidMobileHomePageObjects clickSearchBtn() throws InterruptedException {
		Reporter.log("click on the gallery option icon");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, searchBtn);
		Thread.sleep(2000);
		searchBtn.click();
		return this;
	}

	@Step("Input the shortcode for sending the response")
	public AndroidMobileHomePageObjects searchMobileNumber(String shortCode) throws InterruptedException {
		Reporter.log("Input the shortcode for sending the response");
		AppiumUtils.waitUntillElementToBeVisible(5, 500, enterKeyword);
		Thread.sleep(3000);
		utils.sendKeys(enterKeyword, shortCode);
		return this;
	}

	@Step("Verify the reponse for invalid text")
	public AndroidMobileHomePageObjects verifyRecordExists() throws InterruptedException {
		Reporter.log("Verify the response for the invalid text");
		Thread.sleep(3000);
		System.out.println(driver.getPageSource());
		//getTitle.stream().filter(e->e.getText().equals("30364"));
		
		for (MobileElement str : getTitle) {
			if (str.getText().equals("30364")) {
				str.click();
				clickImageGalleryLink();
				clickDeleteMsgPopupLink();
				clickSelectAllMsgLink();
				clickDeleteIconLink();
				clickConfirmationPopup();
				break;
			} 
		}
		return this;
	}

	@Step("Move to the back page using Android key")
	public AndroidMobileHomePageObjects clickPageBack() throws InterruptedException {
		Reporter.log("Move to the back page using Android key");
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
		return this;
	}
	
	
	@Step("click on the Menu to close the Apps")
	public AndroidMobileHomePageObjects clickMenu() throws InterruptedException {
		Reporter.log("click on the Menu to close the Apps");
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
		/*System.out.println(driver.getPageSource());*/
		closeAllApps.click();
		return this;
	}
	
	
	@Step("click on the gallery option icon")
	public AndroidMobileHomePageObjects clickImageGalleryLink() throws InterruptedException {
		Reporter.log("click on the gallery option icon");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, imageGallery);
		Thread.sleep(2000);
		imageGallery.click();
		return this;
	}

	@Step("click on the delete message popup link")
	public AndroidMobileHomePageObjects clickDeleteMsgPopupLink() throws InterruptedException {
		Reporter.log("click on the delete message popup link");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, deleteMessages);
		Thread.sleep(2000);
		deleteMessages.click();
		return this;
	}

	@Step("click on the select all messages link")
	public AndroidMobileHomePageObjects clickSelectAllMsgLink() throws InterruptedException {
		Reporter.log("click on the select all messages link");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, selectAllMessages);
		Thread.sleep(2000);
		selectAllMessages.click();
		return this;
	}

	@Step("click on the delete icon link")
	public AndroidMobileHomePageObjects clickDeleteIconLink() throws InterruptedException {
		Reporter.log("click on the delete icon link");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, deleteIcon);
		Thread.sleep(2000);
		deleteIcon.click();
		return this;
	}

	@Step("click on the confirmation popup message")
	public AndroidMobileHomePageObjects clickConfirmationPopup() throws InterruptedException {
		Reporter.log("click on the confirmation popup message");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, confirmDeleteMessagePopup);
		Thread.sleep(2000);
		confirmDeleteMessagePopup.click();
		return this;
	}

	@Step("Click on the FAQ link on Huggies Magical HomePage")
	public AndroidMobileHomePageObjects switchMobileHomePage() {
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
		return this;
	}

	@Step("Switch to the native app")
	public AndroidMobileHomePageObjects switchNativeApp() {
		Reporter.log("Switch to the native app");
		driver.context("NATIVE_APP");
		return this;
	}

	@Step("click on the message icon")
	public AndroidMobileHomePageObjects clickMessageAppIcon() throws InterruptedException {
		Reporter.log("click on the message icon");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, messageAppIcon);
		Thread.sleep(5000);
		messageAppIcon.click();
		return this;
	}

	@Step("click for sending the new message")
	public AndroidMobileHomePageObjects clickNewMessageIcon() throws InterruptedException {
		Reporter.log("click for sending the new message");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, newMessageIcon);
		Thread.sleep(3000);
		newMessageIcon.click();
		return this;
	}

	@Step("Input the shortcode for sending the response")
	public AndroidMobileHomePageObjects enterMobileNumberSendTextMessage(String shortCode) throws InterruptedException {
		Reporter.log("Input the shortcode for sending the response");
		AppiumUtils.waitUntillElementToBeVisible(5, 500, enterToMessageNumber);
		Thread.sleep(3000);
		utils.sendKeys(enterToMessageNumber, shortCode);
		return this;
	}

	@Step("Input the keyword for sending the request the response")
	public AndroidMobileHomePageObjects enterTextMessage(String Keyword) throws InterruptedException {
		AppiumUtils.waitUntillElementToBeVisible(5, 500, enterTextMessage);
		Thread.sleep(5000);
		utils.sendKeys(enterTextMessage, Keyword);
		return this;
	}

	@Step("click on the compose button")
	public AndroidMobileHomePageObjects clickComposeSubmitBtn() throws InterruptedException {
		Reporter.log("click on the compose button");
		AppiumUtils.waitUntillElementToBeClickable(5, 500, clickComposebtn);
		Thread.sleep(5000);
		clickComposebtn.click();
		return this;
	}

	@Step("Verify the reponse for invalid text")
	public AndroidMobileHomePageObjects verifyReponseInvalidText() throws InterruptedException {
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
	public AndroidMobileHomePageObjects verifyStopReponseInvalidText() throws InterruptedException {
		Reporter.log("verify the stop response text");
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

	@Step("verify the reponse of COOLIE_REVIEW text request")
	public AndroidMobileHomePageObjects verifyvalidReponseText() throws InterruptedException {
		Reporter.log("verify the reponse of COOLIE_REVIEW text request");
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
	public AndroidMobileHomePageObjects verifyYesReponseText() throws InterruptedException {
		Reporter.log("verify the reponse of YES text request");
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

	@Step("Verify the response for the DOB request")
	public AndroidMobileHomePageObjects verifyValidDobReponseText() throws InterruptedException {
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

	@Step("Verify the response for the valid state request")
	public AndroidMobileHomePageObjects verifyValidStateReponseText() throws InterruptedException {
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

	@Step("Verify the response for the help state request")
	public AndroidMobileHomePageObjects verifyHelpReponseText() throws InterruptedException {
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

	@Step("Verify the response for the STOP text request")
	public AndroidMobileHomePageObjects verifystopReponseText() throws InterruptedException {
		Reporter.log("Verify the response for the STOP text request");
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

	@Step("Verify the response for STOPALL text request")
	public AndroidMobileHomePageObjects verifystopAllReponseText() throws InterruptedException {
		Reporter.log("Verify the response for STOPALL text request");
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

	@Step("Verify the response for invalid Dateofbirth text request")
	public AndroidMobileHomePageObjects verifyinvalidReponseText() throws InterruptedException {
		Reporter.log("Verify the response for invalid Dateofbirth text request");
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
