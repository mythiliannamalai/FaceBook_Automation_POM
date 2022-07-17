package FB.TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import FB.BaseClass.BaseClass;
import FB.Pages.HomePage;
import FB.Pages.LoginPage;
import FB.Pages.ProfilePage;
@Listeners(FB.Lisner.TestLisner.class)
public class ProfilePageTest extends BaseClass{
	LoginPage loginpage ;
	HomePage homepage;
	ProfilePage profilepage;

	public ProfilePageTest() {
		super();
	}
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.clickOnProfile();
		profilepage = new ProfilePage();
	}
	
	@Test(priority=1)
	public void editTheProfileTest() throws AWTException {		
		log.info("editTheProfileTest Method Runing...");
		profilepage.clickEditButtion();
		profilepage.clickAddOption();
		profilepage.enterTheDescribtion();
		profilepage.clickSaveButton();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
