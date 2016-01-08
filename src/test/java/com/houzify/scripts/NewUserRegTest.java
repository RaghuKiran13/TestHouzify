/***********************************************************************
* @author 			:		Shreyas MS
* @description		: 		Test scripts of New User Registration module and Login
* @testmethod		:		testNewUserSignupGallery()
* @testmethod		:		testNewUserSignupCamera()
* @testmethod		:		testInvalidLogin()
* @testmethod		:		testfacebookLogin()
* @testmethod 		:		testgoogleLogin()
*/

package com.houzify.scripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.houzify.PO.HomePO;
import com.houzify.PO.MyProfilePO;
import com.houzify.PO.NewUserRegPO;
import com.houzify.baselib.GenericLib;
import com.houzify.baselib.HouzifyBaseLib;

public class NewUserRegTest extends HouzifyBaseLib
{
	
	public Logger qrLog = Logger.getLogger(this.getClass());
	public String sData[]=null;
	public String sTestCaseID=null;
	
	NewUserRegPO newUserRegPo;
	HomePO homePo;
	MyProfilePO myProfilePo;
	
	/*  @Test id: NewUserRG_01
	 * @description: New User Login by selecting image from gallery and Browse a random number of image <20 And select favorite icon
	 * Author: Shreyas MS
	*/
	
	@Test(priority=1,enabled=true)
	public void testSignUpwithGalleryImg()
	{
		sTestCaseID="NewUserRG_01";
		sData= GenericLib.toReadExcelData(sTestCaseID);
		newUserRegPo = new NewUserRegPO(driver);
		homePo =new HomePO(driver);
		myProfilePo = new MyProfilePO(driver);
		try
		{
			newUserRegPo.signUpWithGalleryImg(sData[1],sData[3],sData[2]);
			Assert.assertTrue(homePo.getEleSlidePanel().isDisplayed(), "Home page is not displayed");
			qrLog.info("Home page is successfully displayed");
			Thread.sleep(4000);
			homePo.swipeHomeImg(20);
			Assert.assertTrue(myProfilePo.getEleFavouriteIcn().isDisplayed(),"Favorite is not selected");
			qrLog.info("Favorite is not selected");
			myProfilePo.getEleFavouriteIcn().click();
			qrLog.info("Favorite color is changed");
		} 
		catch (Exception e)
		{
			qrLog.error("Exception in  case testNewUserSignUpGallery()");
			e.getStackTrace();
			Assert.fail();
		}
	}
	
	
	/*  @Test id: NewUserRG_02
	 * @description: New User Login by selecting image from camera and Browse a random number of image <20 And select favorite icon
	 * Author: Shreyas MS
	*/
	@Test(priority=2,enabled=true)
	public void testSignupWithCameraPic()
	{
		sTestCaseID="NewUserRG_02";
		sData= GenericLib.toReadExcelData(sTestCaseID);
		String sDeviceName = GenericLib.getCongigValue(sConfigFile, "DEVICENAME");
		newUserRegPo = new NewUserRegPO(driver);
		homePo = new HomePO(driver);
		myProfilePo = new MyProfilePO(driver);
		try
		{
			newUserRegPo.signUpUploadCameraImg(sData[1],sData[3], sData[2], homePo,sDeviceName);
			Assert.assertTrue(myProfilePo.getEleFavouriteIcn().isDisplayed(),"Favorite is not selected");
			qrLog.info("Favorite is not selected");
			myProfilePo.getEleFavouriteIcn().click();
			qrLog.info("Favorite color is changed");
		} catch (Exception e) {
			qrLog.error("Exception in  case testSignupWithCameraPic()");
			e.getStackTrace();
			Assert.fail();
		}
	}
	/*  @Test id: NewUserRG_03
	 * @description: Existing user login with different password
	 * Author: Shreyas MS
	*/
	@Test(priority=3,enabled=true)
	public void testInvalidLogin()
	{
		sTestCaseID="NewUserRG_03";
		sData= GenericLib.toReadExcelData(sTestCaseID);
		newUserRegPo = new NewUserRegPO(driver);
		myProfilePo = new MyProfilePO(driver);
		try
		{
			Assert.assertTrue(newUserRegPo.getEleLoginBtn().isDisplayed(),"Login button is not displayed");
			qrLog.info("Login button is displayed");
			newUserRegPo.getEleLoginBtn().click();
			newUserRegPo.invalidLogin(sData[4], sData[2],myProfilePo);
		} 
		catch (Exception e) 
		{
			qrLog.error("Exception in  case testInvalidLogin()");
			e.getStackTrace();
			Assert.fail();
		}
	}
	/*  @description: Existing user login with google+
	 * Author: Shreyas MS
	*/
		@Test(priority=4,enabled=true)
	public void testGoogleLogin()
		{
			newUserRegPo = new NewUserRegPO(driver);
			homePo =new HomePO(driver);
			try
			{
				Assert.assertTrue(newUserRegPo.getEleLoginBtn().isDisplayed(), "Houzify Login is not displayed");
				qrLog.info("Houzify Login is displayed");
				newUserRegPo.getEleLoginBtn().click();
				newUserRegPo.googleLogin();
			} 
			catch (Exception e)
			{
				qrLog.error("Exception in  case testGoogleLogin()");
				e.getStackTrace();
				Assert.fail();
			}
		}
	/* 
	 * @description: Existing user login with Facebook
	 * Author: Shreyas MS
	*/
	@Test(priority=5,enabled=true)
	public void testFBLogin()
		{
			newUserRegPo = new NewUserRegPO(driver);
			homePo =new HomePO(driver);
			try
			{	Assert.assertTrue(newUserRegPo.getEleLoginBtn().isDisplayed(),"Houzify Login is not displayed");
				qrLog.info("Houzify Login is displayed");
				newUserRegPo.getEleLoginBtn().click();
				newUserRegPo.facebookLogin();
				homePo.swipeHomeImg(20);
				} catch (Exception e)
			{
				qrLog.error("Exception in  case testfacebookLogin()");
				e.getStackTrace();
				Assert.fail();
			}
}
		
		
		
}

	
	