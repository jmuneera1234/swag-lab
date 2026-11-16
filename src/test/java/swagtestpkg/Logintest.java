package swagtestpkg;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilitiespkg.Excelutil;
import swagbasepkg.Reporterclass;
import swagbasepkg.swagbaseclass;
import swagpagepkg.Loginpage;

public class Logintest extends swagbaseclass
{
	Loginpage log;
	
	
	//DATA PROVIDER
	
	@DataProvider(name="loginData")
	public Object[][] getData() throws Exception {
		
		String path="C:\\Users\\MUNEERA\\Downloads\\swaglabs.xlsx";
		return Excelutil.getTestData(path, "Sheet1");
	}
	
	
	// LOGIN TEST
	
	@Test(dataProvider="loginData",priority=1)
	
	public void logintest(String user,String password, String status) throws InterruptedException, IOException {
		driver.get("https://www.saucedemo.com/");
		
		test = extent.createTest("Login Test - " + user);
		
		log= new Loginpage (driver);
		
		log.setvalue(user,password);
		
		System.out.println("Executed for: " + user);
		
		String currentUrl=driver.getCurrentUrl();
		
		if(currentUrl.equals("https://www.saucedemo/inventory.html")) {
			test.pass("Login successful for: " + user);
		}
		
		else {
			String screenshotName ="LoginFailed_" + user;
			Reporterclass.screenshotMethod(driver, screenshotName);
			test.addScreenCaptureFromPath("" + screenshotName + ".png");
			test.fail("Login failed for: " + user);
		}
	}
	
	// LOGO VALIDATION
	
	@Test(priority=2)
	
	public void logoverification() throws IOException {
      driver.get("https://www.saucedemo.com/");
		
		test = extent.createTest("Logo verification Test");
		
		log= new Loginpage (driver);
		
		WebElement x= log.logoverification();
		
		if(x.isDisplayed()) {
			test.pass("Logo displayed");
		}else {
			
			String screenshotName="logo_validation";
			Reporterclass.screenshotMethod(driver, screenshotName);
			test.addScreenCaptureFromPath("C:\\Users\\MUNEERA\\eclipse-workspace\\swaglabsproject\\reports\\" + screenshotName + ".png");
			test.fail("Logo not displayed ");
			Assert.fail("Logo not displayed");
		}
	}
	
	// BUTTON TEXT VALIDATION
	
	
 @Test(priority=3)
  
  public void buttontextvalidation() throws IOException {
	 driver.get("https://www.saucedemo.com/");
	 test = extent.createTest("Button Text Validation Test");
		
		log= new Loginpage (driver);
		
		String text=log.login.getDomAttribute("value");
		if (text.equals("Login")) {
			test.pass("Button text is login");
		} else {
			String screenshotName="button_text_validation";
			Reporterclass.screenshotMethod(driver, screenshotName);
			test.addScreenCaptureFromPath("C:\\Users\\MUNEERA\\eclipse-workspace\\swaglabsproject\\reports\\" + screenshotName + ".png");
			test.fail("Button text is not Login");
			Assert.fail("Button text is not Login");
		}
			
		}
	 
	 
 
 
 // PLACE HOLDER VALIDATION
  
 @Test(priority=4)
 public void placeholdervalidation() throws IOException {
	 driver.get("https://www.saucedemo.com/");
	 test = extent.createTest("Placeholder Validation Test");
		
		log= new Loginpage (driver);
		
		String username=log.username.getDomAttribute("placeholder");
		String password=log.pass.getDomAttribute("placeholder");
		if (username.equals("Username") && password.equals("Password")) {
			test.pass("Placeholder validation passed");
		} else {
			String screenshotName="placeholder_validation";
			Reporterclass.screenshotMethod(driver, screenshotName);
			test.addScreenCaptureFromPath("C:\\Users\\MUNEERA\\eclipse-workspace\\swaglabsproject\\reports\\" + screenshotName + ".png");
			test.fail("Placeholder validation failed ");
			Assert.fail("Placeholder validation failed");
		}
		
		}
 
     //TITLE VALIDATION
				
	 
  @Test(priority=5)
	  public void fetchtitle() throws IOException {
	  
	  driver.get("https://www.saucedemo.com/");
	  test = extent.createTest("Title Validation Test");
	  
	  String act= driver.getTitle();
	  String exp= "Swag Labs";
	  if (exp.equals(act)) {
		  test.pass("Title validation passed");
	  } else {
		  String screenshotName="title_validation";
			Reporterclass.screenshotMethod(driver, screenshotName);
			test.addScreenCaptureFromPath("C:\\Users\\MUNEERA\\eclipse-workspace\\swaglabsproject\\reports\\" + screenshotName + ".png");
			test.fail("Title validation failed ");
			Assert.fail("Title validation failed");
		}
		  
	  }
}
	
		
		  
	  
			
			
			
			
			
			
		
		
		
		
		
	
					
					
		
		
	
	
	
	
	
	


