/***********************************************************************
* @author 			:		Shreyas MS
* @description		: 		Test scripts of First Login on any Device/Verifying the Tutorial page
* @testmethod 		:		testTutorial()
*/

package com.houzify.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.houzify.PO.HomePO;
import com.houzify.PO.NewUserRegPO;
import com.houzify.baselib.GenericLib;
import com.houzify.baselib.HouzifyBaseLib;


public class TutorialTest extends HouzifyBaseLib
{
	public String sData[]=null;
	public String sTestCaseID=null;
	public Logger qrLog = Logger.getLogger(this.getClass());
	NewUserRegPO newUserRegPo;
	HomePO homePo;
	
	
	/*  @Test id: Tutorial_01
	 * @description: Test scripts of First Login on any Device/Verifying the Tutorial page
	 * Author: Shreyas MS
	*/
	@Test(priority=1,enabled=true)
	public void testTutorial()
	{
		sTestCaseID="Tutorial_01";
		sData= GenericLib.toReadExcelData(sTestCaseID);
		newUserRegPo=new NewUserRegPO(driver);
		homePo = new HomePO(driver);
		try
		{
			newUserRegPo.newUserSignup(sData[1],sData[3],sData[2]);
			homePo.swipeTutorialImg();
		}
		catch(Exception e)
		{
			qrLog.error("Exception in  case testTutorial()");
			e.getStackTrace();
			Assert.fail();
		}
	}

}
