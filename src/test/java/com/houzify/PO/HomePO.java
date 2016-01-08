package com.houzify.PO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class HomePO {
	AndroidDriver driver = null;
	public Logger qrLog = Logger.getLogger(this.getClass());
	
	public HomePO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id ="com.houzify:id/slidingPanel")
	private WebElement eleSlidePanel;
	public WebElement getEleSlidePanel()
	{
		return eleSlidePanel;
	}
	@FindBy(name="Swipe to Continue")
	private WebElement eleSwipetoContBtn;
	public WebElement getSwipetoContBtn()
	{
		return eleSwipetoContBtn;
	}
	
	@FindBy(name="Got it!")
	private WebElement eleGotItBtn;
	public WebElement getGotItBtn()
	{
		return eleGotItBtn;
	}
	
	public void swipeHomeImg(int count) throws InterruptedException{
		try{
			Thread.sleep(5000);
			for(int i=0;i<count;i++)
			{
				driver.swipe(690, 690, 100, 690, 1000);
				qrLog.info("Swiping "+i+" Image");
				Thread.sleep(3000);
			}
			qrLog.info("Thus, swiping" +count+ "number of images is successful");
			
			}
		catch(Exception e)
		{	qrLog.error("Failed to image. Exception at swipeHomeImg");
			e.getStackTrace();
			Assert.fail();
		}
		
	}


	
	public void swipeTutorialImg() throws InterruptedException
	{
		MyProfilePO myProfilePo = new MyProfilePO(driver);
		HomePO homePo = new HomePO(driver);
		try{
			
			driver.findElement(By.name("Navigate up")).click();
			myProfilePo.getEleTopPicksBtn().click();
			Thread.sleep(2000);
			Assert.assertTrue(homePo.getSwipetoContBtn().isDisplayed(), "Tutorial page is not displayed");
			qrLog.info("Tutorial Page is displayed");
			Thread.sleep(1000);
			homePo.getSwipetoContBtn().click();
			swipeHomeImg(3);
			Assert.assertTrue(homePo.getSwipetoContBtn().isDisplayed(), "Tutorial page is not displayed");
			qrLog.info("Tutorial Page is displayed");
			Thread.sleep(1000);
			homePo.getSwipetoContBtn().click();
			swipeHomeImg(3);
			driver.findElement(By.name("Navigate up")).click();
			Thread.sleep(2000);
			myProfilePo.getEleHomeBtn().click();
			Thread.sleep(2000);
			swipeHomeImg(3);
		}
		catch(Exception e)
		{
			qrLog.error("Failed to image. Exception at swipeTutorialImg");
			e.getStackTrace();
			Assert.fail();
		}
	}

}
