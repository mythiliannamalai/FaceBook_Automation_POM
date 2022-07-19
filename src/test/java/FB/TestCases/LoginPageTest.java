package FB.TestCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import FB.BaseClass.BaseClass;
import FB.Pages.ForgottPasswordPage;
import FB.Pages.HomePage;
import FB.Pages.LoginPage;
import FB.Utility.UtilityClass;
public class LoginPageTest extends BaseClass {	
	
	LoginPage loginpage ;
	HomePage homepage;	
	UtilityClass utility;
	public static String SheetName="Sheet2";
	
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
	loginpage.forgottPassword();	
}
@DataProvider
public Object[][] getLoginTestData(){
	Object data[][] = utility.getTestData(SheetName);
	return data;
}

@Test(dataProvider ="getLoginTestData",priority=4)
public void mulitipleUserLoginTest(String username,String passWord) {
	log.info("mulitipleUserLoginTest Method Runing...");
	loginpage.mulitipleUserLogin(username, passWord);
	
}
@AfterMethod
public void tearDown() throws InterruptedException {
	Thread.sleep(5000);
	driver.quit();
}
}
