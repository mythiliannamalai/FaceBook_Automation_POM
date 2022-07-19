package FB.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FB.BaseClass.BaseClass;

public class HomePage extends BaseClass {	
	
	//Object Repository
@FindBy(xpath="//span[text()='Mythili Naveenkumar']")
WebElement profile;

@FindBy(xpath="//span[text()='Find Friends']")
WebElement friends;

@FindBy(xpath="//a[@aria-label='Home']")
WebElement home;

@FindBy(xpath="//div[@class='bp9cbjyn is6700om qavdm89g gsh9l1b6 lwukve8w jpyiy761 j83agx80 k7cz35w2 taijpn5t bsnbvmp4']")
WebElement createStory; 

@FindBy(xpath="//div[text()='Create a Text Story']")
WebElement textStory;

@FindBy(xpath="//textarea[@dir='ltr']")
WebElement text;

@FindBy(xpath="//span[text()='Share to Story']")
WebElement Share;

//Intizilation
public HomePage() {
	PageFactory.initElements(driver, this);
}

public String checkProfileText() {
	return profile.getText();
}

public ProfilePage clickOnProfile() {	
	profile.click();
	return new ProfilePage();	
}

public String FindFriendsText() {
	return friends.getText();
}

public void clickOnFindFriends() {		
	friends.click();	
	}

public void createNewStory(){
	home.click();
	createStory.click();
	textStory.click();
	text.sendKeys("Be Happy.....");
	Share.click();
}
	
	
}
