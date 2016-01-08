package com.houzify.PO;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class FilterPO {
	AndroidDriver driver = null;
	public Logger qrLog = Logger.getLogger(this.getClass());
	public FilterPO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name ="Filter")
	private WebElement eleFilterBtn;
	public WebElement getEleFilterBtn()
	{
		return eleFilterBtn;
	}
	
	@FindBy(name ="Navigate up")
	private WebElement eleMenuIcn;
	public WebElement getEleMenuIcn()
	{
		return eleMenuIcn;
	}
	@FindBy(name ="LIVING ROOM")
	private WebElement eleLivingRoomIcn;
	public WebElement getEleLivingRoomIcn()
	{
		return eleLivingRoomIcn;
	}

	@FindBy(name ="DINING AREA")
	private WebElement eleDiningAreaIcn;
	public WebElement getEleDiningAreaIcn()
	{
		return eleDiningAreaIcn;
	}
	
	//Tap on filter and Select one of the categories and browse more than 10 images
	public void livingRmSliding() throws InterruptedException{
		HomePO homePo = new HomePO(driver);
		try
		{		Thread.sleep(3000);
				driver.swipe(690, 690, 100, 690, 1000);
				Thread.sleep(3000);
				getEleMenuIcn().click();
				getEleFilterBtn().click();
				//Selecting the Living room category in filter
				Thread.sleep(3000);
				getEleLivingRoomIcn().click();
				Thread.sleep(3000);
				homePo.swipeHomeImg(12);
			}catch(Exception e)
			{
				qrLog.error("Exception at filter");
				e.getStackTrace();
				Assert.fail();
			}
	}
	
	//Tap on filter and Select one of the categories and browse more than 10 images
	public void dinnerAreaSliding() throws InterruptedException{
		HomePO homePo = new HomePO(driver);
		try{
				Thread.sleep(3000);
				driver.swipe(690, 690, 100, 690, 1000);
				Thread.sleep(2000);
				getEleMenuIcn().click();
				getEleFilterBtn().click();
				Thread.sleep(3000);
				//Selecting the Dining Area category in filter
				Thread.sleep(3000);
				getEleDiningAreaIcn().click();
				Thread.sleep(3000);
				homePo.swipeHomeImg(17);
			}
			catch(Exception e)
		{
				qrLog.error("Exception at filterbrowser");
				e.getStackTrace();
				Assert.fail();
		}
	}
	
}
