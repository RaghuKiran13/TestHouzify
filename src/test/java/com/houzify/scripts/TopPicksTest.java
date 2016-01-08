/***********************************************************************
* @author 			:		Raghukiran MR
* @description		: 		Tap on top picks and browse the more than 10 images
* @testmethod		:		testFilterBrowse10images()
* 
*/
package com.houzify.scripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.houzify.PO.FilterPO;
import com.houzify.PO.HomePO;
import com.houzify.PO.MyProfilePO;
import com.houzify.PO.NewUserRegPO;
import com.houzify.baselib.GenericLib;
import com.houzify.baselib.HouzifyBaseLib;

public class TopPicksTest extends HouzifyBaseLib
{
	public String sData[]=null;
	public String sTestCaseID=null;
	NewUserRegPO newUserRegPo;
	HomePO hzcontrolPo;
	FilterPO filterPo;
	MyProfilePO myProfilePo;
	public Logger qrLog = Logger.getLogger(this.getClass());
	
	/*@Test id:TopPick_01
	 * @description:Tap on top picks and browse the more than 10 images
	 * @author:Raghukiran MR
	 * 
	 */
	@Test(priority=1,enabled=true)
	public void testTopPicksBrowse10images()
	{
		sTestCaseID="TopPick_01";
		sData= GenericLib.toReadExcelData(sTestCaseID);
		myProfilePo = new MyProfilePO(driver);
		newUserRegPo  = new NewUserRegPO(driver);
		try
		{	
			 myProfilePo.swipetpPickesImg(sData[4],sData[2],newUserRegPo, myProfilePo);
		}
		catch (Exception e) 
		{
			qrLog.error("Exception in  case testFilterBrowse10images");
			e.getStackTrace();
			Assert.fail();
		}
	}

}
