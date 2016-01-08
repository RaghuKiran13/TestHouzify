/***********************************************************************
* @author 			:		Raghukiran MR
* @description		: 		Tap on the home icon and browse the image
* @testmethod		:		testHomeBrowseimage()

* */
package com.houzify.scripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.houzify.PO.FilterPO;
import com.houzify.PO.HomePO;
import com.houzify.PO.MyProfilePO;
import com.houzify.PO.NewUserRegPO;
import com.houzify.baselib.GenericLib;
import com.houzify.baselib.HouzifyBaseLib;

public class HomeTest extends HouzifyBaseLib
{
	public String sData[]=null;
	public String sTestCaseID=null;
	
	public Logger qrLog = Logger.getLogger(this.getClass());
	FilterPO filterPo;
	MyProfilePO myProfilePo;
	NewUserRegPO newUserRegPo;
	HomePO homePo;
	/*@Test id:Home_01
	 * @description:TaP ON Home option and browse the 5 images
	 * @author:Raghukiran MR
	 * 
	 */
	@Test(priority=1,enabled=true)
	public void testHomeBrowseimage()
	{
		sTestCaseID="Home_01";
		filterPo = new FilterPO(driver);
		myProfilePo = new MyProfilePO(driver);
		homePo = new HomePO(driver);
		newUserRegPo = new NewUserRegPO(driver);
		sData= GenericLib.toReadExcelData(sTestCaseID);
		try
		{	
			newUserRegPo.login(sData[4],sData[2],myProfilePo);
			Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Login is not successful");
			qrLog.info("User Login is successful");
			
			
			homePo.swipeHomeImg(1);
			Thread.sleep(3000);
						
			driver.findElementByName("Navigate up").click();
			Assert.assertTrue(myProfilePo.getEleHomeBtn().isDisplayed(), "Home option is not displayed");
			qrLog.info("Home option is displayed");
			//Tap On Home page and browse more than the 5 image 
			myProfilePo.getEleHomeBtn().click();
			homePo.swipeHomeImg(5);
			
			driver.findElementByName("Navigate up").click();
			Assert.assertTrue(myProfilePo.getEleHomeBtn().isDisplayed(), "Home option is not displayed");
			qrLog.info("Home option is displayed");
			//Tap On Home page and browse more than the 7 image 
			myProfilePo.getEleHomeBtn().click();
			homePo.swipeHomeImg(7);
						
			driver.findElementByName("Navigate up").click();
			Assert.assertTrue(myProfilePo.getEleHomeBtn().isDisplayed(), "Home option is not displayed");
			qrLog.info("Home option is displayed");
			//Tap On Home page and browse more than the 12 image 
			myProfilePo.getEleHomeBtn().click();
			homePo.swipeHomeImg(12);
			}
		catch (Exception e) {
			qrLog.error("Exception in  case testHomeBrowse5image");
			e.getStackTrace();
			Assert.fail();
		}
	}
}
