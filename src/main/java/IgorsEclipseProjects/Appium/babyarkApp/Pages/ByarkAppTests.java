package IgorsEclipseProjects.Appium.babyarkApp.Pages;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;





public class ByarkAppTests extends BaseClass {
	
	public void fromeWelcomePageToSignINPage() {
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
		driver.findElement(AppiumBy.accessibilityId("Next")).click();
//		Activity activity = new Activity("com.babyark.app", "com.mobius.babyark.MainActivity");
//		driver.startActivity(activity);
//		driver.navigate().back();		
//		driver.findElement(AppiumBy.accessibilityId("Next")).click();
//	    allow permission
//		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
	
	}

	@Test
	public void LoginValid() {
		
         fromeWelcomePageToSignINPage();
		//click on the logIn Button to go to login page
		driver.findElement(AppiumBy.accessibilityId("Login")).click();
		
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("igor@babyark.com");
		driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys("aassdd");
		driver.hideKeyboard();
		driver.findElement(AppiumBy.accessibilityId("Login")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = driver.findElement(AppiumBy.accessibilityId("Live Status")).getAttribute("content-desc");
		assertEquals(str, "Live Status");
		
	}
	
	@Test
	public void RegistrationValid() {
		
		
		
	}
	
	
}
