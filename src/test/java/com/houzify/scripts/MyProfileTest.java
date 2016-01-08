/***********************************************************************
* @author 			:		Raghukiran MR
* @description		: 		Browse My Favourites
* @testmethod		:		testMyProfileFavourites()
* 
*/
package com.houzify.scripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.houzify.PO.FilterPO;
import com.houzify.PO.MyProfilePO;
import com.houzify.PO.NewUserRegPO;
import com.houzify.baselib.GenericLib;
import com.houzify.baselib.HouzifyBaseLib;

public class MyProfileTest extends HouzifyBaseLib {
	public String sData[]=null;
	public String sTestCaseID=null;
	public Logger qrLog = Logger.getLogger(this.getClass());
	FilterPO filterPo;
	MyProfilePO myProfilePo;
	NewUserRegPO newUserRegPo;
	
	/*@Test id:MyProfile_01
	 * @description:Browse My Favourites
	 * @author:Raghukiran MR
	 * 
	 */
	@Test(priority=1,enabled=true)
	public void testSwipeFavouriteImages()
	{
		sTestCaseID="MyProfile_01";
		sData= GenericLib.toReadExcelData(sTestCaseID);
		myProfilePo = new MyProfilePO(driver);
		newUserRegPo = new NewUserRegPO(driver);
		filterPo = new FilterPO(driver);
		try
		{	newUserRegPo.login(sData[4],sData[2],myProfilePo);
			Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Login is not successful");
			qrLog.info("User Login is successful");
			myProfilePo.swipeFavImg();
		} 
		catch (Exception e) {
			qrLog.error("Exception in  case testMyProfileFavourites");
			e.getStackTrace();
			Assert.fail();
		}
			
	}
}

