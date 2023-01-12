package IgorsEclipseProjects.Appium.babyarkApp.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class babyarkWebTest {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void startChrome() {
		System.setProperty("webdriver.chrome.driver", "/Users/igorvainman/Downloads/chromedriver 108.05");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		driver.get("https://www.babyark.com");

	}

	@Test(invocationCount = 20)
	public void EnterToCheckoutPage() {

//		driver.findElement(By.xpath("//button[normalize-space()='Accept']")).click();
//
//		wait.until(ExpectedConditions.elementToBeClickable(
//				driver.findElement(By.xpath("(//span[@class='MuiButton-label'][normalize-space()='Buy'])[1]"))));
//		
//		driver.findElement(By.xpath("(//span[@class='MuiButton-label'][normalize-space()='Buy'])[1]")).click();
		
		driver.get("https://shop.babyark.com/products/babyark");

		driver.findElement(By.xpath("(//span[contains(text(),'Pay $50 Deposit')])[1]")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.cssSelector("a[aria-label='Shop Pay']"))));

		String str = driver.findElement(By.xpath("//a[@class='JXMCh']")).getText();
		Assert.assertEquals(str, "babyark");
	}

	@AfterClass
	public void terdown() {
		if (driver != null) {
			driver.close();
		}
	}
}
