package FB.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import FB.BaseClass.BaseClass;

public class LoginPage extends BaseClass{
	//Object Repository
@FindBy(id="email")
WebElement userName;

@FindBy(id="pass")
WebElement password;

@FindBy(xpath="//button[@name='login']")
WebElement login;

@FindBy(linkText="Forgotten password?")
WebElement forgotpass;

public LoginPage(){
	PageFactory.initElements(driver, this);
}

//Action
public String ValidateLoginpageTitle() {
	return driver.getTitle();
}

public HomePage Login(String un,String pass) throws InterruptedException {
	userName.sendKeys(un);
	password.sendKeys(pass);
	login.click();
	Thread.sleep(5000);
	return new HomePage();	
}

public void forgottPassword() {
	forgotpass.click();	
}

public HomePage mulitipleUserLogin(String username,String passWord) {
	userName.sendKeys(username);
	password.sendKeys(passWord);
	login.click();	
	return new HomePage();
}

}
