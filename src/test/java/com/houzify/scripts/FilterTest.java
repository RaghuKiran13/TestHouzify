/***********************************************************************
* @author 			:		Raghukiran MR
* @description		: 		Tap on Filter and Select one of the categories and browse moe than the 10 and 15 images
* @testmethod		:		testFilterBrowse10images()
* @testmethod		:		testFilterBrowse15images()
* */
package com.houzify.scripts;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.houzify.PO.FilterPO;
import com.houzify.PO.HomePO;
import com.houzify.PO.MyProfilePO;
import com.houzify.PO.NewUserRegPO;
import com.houzify.baselib.GenericLib;
import com.houzify.baselib.HouzifyBaseLib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class FilterTest extends HouzifyBaseLib
{
	public String sData[]=null;
	public String sTestCaseID=null;
	public Logger qrLog = Logger.getLogger(this.getClass());
	FilterPO filterPo;
	MyProfilePO myProfilePo;
	NewUserRegPO newUserRegPo;
	HomePO homePo;
	
	/*@Test id:Filter_01
	 * @description:Tap on filter and Select one of the categories.Browser more than the 10 images
	 * @author:Raghukiran MR
	 * 
	 */
	@Test(priority=1,enabled=true)
	public void testFilterBrowse10images()
	{
		sTestCaseID="Filter_01";
		sData= GenericLib.toReadExcelData(sTestCaseID);
		filterPo = new FilterPO(driver);
		myProfilePo = new MyProfilePO(driver);
		newUserRegPo = new NewUserRegPO(driver);
		try
		{	
			newUserRegPo.login(sData[4],sData[2],myProfilePo);
			Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Login is not successful");
			qrLog.info("User Login is successful");
			filterPo.livingRmSliding();
		}catch (Exception e) {
			qrLog.error("Exception in  case testFilterBrowse10images");
			e.getStackTrace();
			Assert.fail();
		}
		}
	/*@Test id:Filter_01
	 * @description:Tap on filter and Select one of the categories.Browser more than the 15 images
	 * @author:Raghukiran MR
	 * 	 */
	@Test(priority=2,enabled=true)
	public void testFilterBrowse15images()
	{
		sTestCaseID="Filter_01";
		filterPo = new FilterPO(driver);
		myProfilePo=new MyProfilePO(driver);
		newUserRegPo = new NewUserRegPO(driver);
		sData= GenericLib.toReadExcelData(sTestCaseID);
		try
		{	newUserRegPo.login(sData[4],sData[2],myProfilePo);
			Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Login is not successful");
			qrLog.info("User Login is successful");
			filterPo.dinnerAreaSliding();
		}catch (Exception e) {
			qrLog.error("Exception in  case testFilterBrowse15images");
			e.getStackTrace();
			Assert.fail();
		}
		}
	
}
