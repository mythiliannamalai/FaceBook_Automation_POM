package FB.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FB.BaseClass.BaseClass;
import FB.Pages.ForgottPasswordPage;
import FB.Pages.HomePage;
import FB.Pages.LoginPage;
public class LoginPageTest extends BaseClass {	
	
	LoginPage loginpage ;
	HomePage homepage;
	ForgottPasswordPage forgottpage;
	public LoginPageTest(){
		super();		
	}
	 
@BeforeMethod
public void setUp(){
	initialization();	
		loginpage = new LoginPage();	
}

@Test(priority=1)
public void LoginPageTitleTest() {
	log.info("LoginPageTitleTest Method Runing...");
	String title = loginpage.ValidateLoginpageTitle();
	Assert.assertEquals(title,"Facebook – log in or sign up");
}

@Test(priority=2)
public void LoginTest() throws InterruptedException {
	log.info("LoginTest Method Runing...");
	homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
}

@Test(priority=3)
public void forgottPasswordTest() {
	log.info("forgottPasswordTest Method Runing...");
	forgottpage = loginpage.forgottPassword();	
}
@AfterMethod
public void tearDown() throws InterruptedException {
	Thread.sleep(5000);
	driver.quit();
}
}
