package swagpagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"user-name\"]")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement pass;
	
	@FindBy(name="login-button")
	public WebElement login;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]")
	public WebElement logo;
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement logoverification()
	{
		return logo;
	}
	
	public WebElement buttontext()
	{
		return login;
	}
	
	public void setvalue(String user,String pwd) throws InterruptedException {
		username.sendKeys(user);
		pass.sendKeys(pwd);
		login.click();
		
	}

}
