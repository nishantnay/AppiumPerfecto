package ePrize.androidMobile.utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Reporter;

import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.Job;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	// protected static AndroidDriver<MobileElement> driver;
	protected static AndroidDriver driver;
	protected static ReportiumClient reportiumClient;

	public static AndroidDriver<MobileElement> getAppiumDriver(String deviceId) throws IOException {
		try {
			String browserName = "mobileOS";
			DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);
			String host = "mobilecloud.perfectomobile.com";
			capabilities.setCapability("user", "mobile_testacct_qa@helloworld.com");
			capabilities.setCapability("password", "Perfecto123$");
			capabilities.setCapability("deviceName", deviceId);
			PerfectoLabUtils.setExecutionIdCapability(capabilities, host);
			driver = new AndroidDriver<MobileElement>(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"),
					capabilities);
			PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
					.withProject(new Project("My Project", "1.0")).withJob(new Job("My Job", 45))
					.withContextTags("tag1").withWebDriver(driver).build();
			reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
			reportiumClient.testStart("My test name", new TestContext("tag2", "tag3"));
			// return driver;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public void sendKeys(MobileElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Reporter.log("Unable to enter the keys: " + element + e.getMessage());
		}
	}

	public static void waitUntillElementToBeClickable(int TotalTimeInSeconds, int PollingTimeInMilliseconds,
			MobileElement Element) {
		FluentWait<MobileDriver> ClickableWait = new FluentWait<MobileDriver>(driver)
				.withTimeout(TotalTimeInSeconds, TimeUnit.SECONDS)
				.pollingEvery(PollingTimeInMilliseconds, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		ClickableWait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	/* To Wait Until Element to be Visible */
	public static void waitUntillElementToBeVisible(int TotalTimeInSeconds, int PollingTimeInMilliseconds,
			MobileElement Element) {
		FluentWait<MobileDriver> visibleWait = new FluentWait<MobileDriver>(driver)
				.withTimeout(TotalTimeInSeconds, TimeUnit.SECONDS)
				.pollingEvery(PollingTimeInMilliseconds, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		visibleWait.until(ExpectedConditions.visibilityOf(Element));
	}

}
