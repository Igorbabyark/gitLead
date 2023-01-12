package IgorsEclipseProjects.Appium.babyarkApp.Pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	
	
		
		AndroidDriver driver;
		
		@BeforeClass
		public void configureAppium() {
			try {
				configureAndroidDriver();
			} catch (MalformedURLException e) {
				// handle the exception
			}
		}
		private void configureAndroidDriver() throws MalformedURLException {

			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Android Device");
		//	options.setChromedriverExecutable("//Users/igorvainman/Downloads/chromedriver");
			
			options.setCapability("appPackage", "com.babyark.app");
		    options.setCapability("appActivity", "com.mobius.babyark.MainActivity");
			
		//	options.setApp("//Users//igorvainman//eclipse-workspace//Appium//src//test//java//resources//app-release.apk");
			options.setCapability("autoGrantPermissions", true);
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		
		@AfterClass
		public void tearDown() {
			if (driver != null) {
				driver.close();
			}
		}
	
     
	public BaseClass longPress(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));
		return this;
	}

	public BaseClass ScrollUntilElementsTextVisible(String textOfElement)
			throws MalformedURLException, InterruptedException {
		// TO VIEW ELEMENT
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + textOfElement + "\"));"));
		return this;
	}

	public Double getFormatedAmount(String amount) {
		return Double.parseDouble(amount.substring(1));
	}

	public BaseClass WainUntillAtribute(String elementId, String elementAtribut, String atributeName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id(elementId)), elementAtribut,
				atributeName));
		return this;
	}
	public BaseClass WainUntillAtributeAccId(String accesabilityId, String elementAtribut, String atributeName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(AppiumBy.accessibilityId(accesabilityId)), elementAtribut,
				atributeName));
		return this;
	}

}


