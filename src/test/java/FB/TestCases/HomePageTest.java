package FB.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import FB.BaseClass.BaseClass;
import FB.Pages.FindFriendsPage;
import FB.Pages.HomePage;
import FB.Pages.LoginPage;
import FB.Pages.ProfilePage;
@Listeners(FB.Lisner.TestLisner.class)
public class HomePageTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;	
	ProfilePage profilepage;
	FindFriendsPage findfriendpage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));		
	}
	@Test(priority=1)
	public void checkProfileTextTest() {
		log.info("checkProfileTextTest Method Runing...");
		String text = homepage.checkProfileText();
		Assert.assertEquals(text, "Mythili Naveenkumar");
		}
	
	@Test(priority=2)
	public void clickOnProfileTest() {
		log.info("clickOnProfileTest Method Runing...");
		profilepage = homepage.clickOnProfile();		
	}
	
	@Test(priority=3)
	public void FindFriendstextTest() {
		log.info("FindFriendstextTest Method Runing...");
		String text = homepage.FindFriendsText();
		Assert.assertEquals(text, "Find Friends");
	}
	
	@Test(priority=4)
	public void FindFriendsVisibleTextTest() {
		log.info("FindFriendsVisibleTextTest Method Runing...");
		findfriendpage = homepage.clickOnFindFriends();			
	}
	
	@Test(priority=5)
	public void createStoryTest() {
		log.info("createStoryTest Method Runing...");
		homepage.createNewStory();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
