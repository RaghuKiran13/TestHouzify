package com.houzify.PO;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class MyProfilePO {
	AndroidDriver driver = null;
	public Logger qrLog = Logger.getLogger(this.getClass());
	public MyProfilePO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name ="Home")
	private WebElement eleHomeBtn;
	public WebElement getEleHomeBtn()
	{
		return eleHomeBtn;
	}
	@FindBy(id="com.houzify:id/favoriteButton")
	private WebElement eleFavouriteIcn;
	public WebElement getEleFavouriteIcn()
	{
		return eleFavouriteIcn;
	}
	
	@FindBy(name ="My Profile")
	private WebElement eleMyProfileBtn;
	public WebElement getEleMyProfileBtn()
	{
		return eleMyProfileBtn;
	}
	@FindBy(id="com.houzify:id/homeButton")
	private WebElement eleArrowIcn;
	public WebElement getEleArrowIcn()
	{
		return eleArrowIcn;
	}
	@FindBy(name ="Top Picks")
	private WebElement eleTopPicksBtn;
	public WebElement getEleTopPicksBtn()
	{
		return eleTopPicksBtn;
	}
	
	@FindBy(name ="LET ME IN")
	private WebElement eleLetMeInBtn;
	public WebElement getEleLetMeInBtn()
	{
		return eleLetMeInBtn;
	}
	
	//Swiping favourite images
	public void swipeFavImg() throws InterruptedException{
		HomePO homePo=new HomePO(driver);
		try{			
				Thread.sleep(3000);
				driver.swipe(690, 690, 100, 690, 1000);
				Thread.sleep(3000);
				
				driver.findElementByName("Navigate up").click();
				//Selecting Home category
				getEleHomeBtn().click();
				Thread.sleep(1000);
				getEleFavouriteIcn().click();
				//Swiping home images
				homePo.swipeHomeImg(1);
				getEleFavouriteIcn().click();
				//Swiping home images
				homePo.swipeHomeImg(1);
				getEleFavouriteIcn().click();
				driver.findElementByName("Navigate up").click();
				getEleMyProfileBtn().click();
				driver.scrollToExact("My Profile");
				driver.tap(1,356,540,1);
				homePo.swipeHomeImg(1);
				
				Assert.assertTrue(getEleFavouriteIcn().isDisplayed(), "Favourites icon colour is not changed");
				qrLog.info("Favourites icon colour is changed");
				homePo.swipeHomeImg(1);
				Assert.assertTrue(getEleFavouriteIcn().isDisplayed(), "Favourites icon colour is not changed");
				qrLog.info("Favourites icon colour is changed");
				homePo.swipeHomeImg(1);
				Assert.assertTrue(getEleArrowIcn().isDisplayed(), "Favourites icon colour is not changed");
				qrLog.info("Favourites icon colour is changed");
				
				//Tap on arrow icon and tap on 3rd image 
				getEleArrowIcn().click();
				driver.tap(1,814,540,1);
				homePo.swipeHomeImg(3);
				
				//Clear up the code 
				homePo.swipeHomeImg(1);
				getEleFavouriteIcn().click();
				homePo.swipeHomeImg(1);
				getEleFavouriteIcn().click();
				homePo.swipeHomeImg(1);
				getEleFavouriteIcn().click();
				}
		catch(Exception e)
				{
					qrLog.error("Exception at swipeFavImg");
					e.getStackTrace();
					Assert.fail();
				}
		}
	
	//Swiping top pics Images
	public void swipetpPickesImg(String sEmail,String sPassword, NewUserRegPO newUserRegPo, MyProfilePO myProfilePo)
	{
		HomePO homePo=new HomePO(driver);
		FilterPO filterPo = new FilterPO(driver);
		try{
				newUserRegPo.login(sEmail,sPassword,myProfilePo);
				Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Login is not successful");
				qrLog.info("User Login is successful");		
				Thread.sleep(3000);
				driver.swipe(690, 690, 100, 690, 1000);
				driver.findElementByName("Navigate up").click();
				Assert.assertTrue(getEleTopPicksBtn().isDisplayed(), "Top Picks category is not displayed");
				qrLog.info("Top Picks category is not displayed");	
				getEleTopPicksBtn().click();
				homePo.swipeHomeImg(12);
		}
		catch(Exception e)
		{
			qrLog.error("Exception at  swipetpPickesImg");
			e.getStackTrace();
			Assert.fail();
		}
	}
}