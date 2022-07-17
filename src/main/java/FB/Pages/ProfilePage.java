package FB.Pages;



import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FB.BaseClass.BaseClass;

public class ProfilePage extends BaseClass {

	//Object Repository
	@FindBy(xpath="//span[text()='Edit profile']")
	WebElement EditProfile;
	
	@FindBy(xpath="//span[text()='Edit']")
	WebElement Edit;
	
	@FindBy(xpath="//textarea[@placeholder='Describe who you are']")
	WebElement Describe;
	
	@FindBy(xpath="//span[text()='Save']")
	WebElement Save;
	
	//Inizilation
	public ProfilePage() {
		PageFactory.initElements(driver,this);
	}
	
	//Action	

	public void clickEditButtion() {		
		EditProfile.click();
	}
	
	public void clickAddOption() throws AWTException {
		Robot robot = new Robot();
		robot.mouseWheel(1);
		Edit.click();
	}
	
	public void enterTheDescribtion() {		
		Describe.sendKeys("Create your Happyness....");		
	}
	
	public void clickSaveButton() {
		Save.click();
	}
}
