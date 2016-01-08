/***********************************************************************
* @author 			:		LAKSHMI BS
* @description		: 		Implemented ITestListener interface and overrided methods as per requirement. It listenes to all the events performed by Testng and keep track of it.
* @method			:		onTestStart()
* @method			:		onTestSuccess()
* @method			:		onTestFailure()
* @method 			:		onTestSkipped()
* @method			:		onTestFailedButWithinSuccessPercentage()		
* @method 			:		onStart()
* @method 			:		onFinish()
* @method 
*/

package com.houzify.baselib;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class HouzifyTestngListener implements ITestListener 
{
	
	public Logger qrLog;
	public static int iPassCount=0;
	public static int iFailCount=0;
	public static int iSkippedCount=0;
	public static ArrayList sTestName= new ArrayList<String>();
	public static ArrayList sStatus= new ArrayList<String>();
	public static String sSheet1="Results";
	public static String sSheet2="Test Status";

	int cnt=0;
	static int i=0;

	public  HouzifyTestngListener() 
	{

		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		String sdate1 = sdf.format(date);
		System.setProperty("sFileName",sdate1);
		qrLog= Logger.getLogger(this.getClass());
	try{
		System.out.println();
		GenericLib.sFile=GenericLib.sFile+sdate1+".xlsx";
		
		OutputStream fos = new FileOutputStream(GenericLib.sFile);
		HSSFWorkbook hwb = new HSSFWorkbook();
		HSSFSheet sheet = hwb.createSheet(sSheet1);
		hwb.createSheet(sSheet2);
		
		FileOutputStream fileOut = new FileOutputStream(GenericLib.sFile);
		hwb.write(fos);
		fileOut.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void onTestStart(ITestResult result) 
	{
		qrLog.info("_____________	   RUNNING TESTCASE 	___________");
		qrLog.info("TESTCASE ID  =  	"+result.getName().toString()+"                    ");
		
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		GenericLib.setStatus(result.getName().toString(), "Passed",sTestName,sStatus);
		qrLog.info("TEST STATUS  =   	PASSED"+"                    ");
		qrLog.info("___________________________________________________");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
		String sdate = sdf.format(date);
		String sImage=result.getName().toString().replace("test","");
		Object obj=result.getInstance();
		HouzifyBaseLib baseLib = (HouzifyBaseLib)obj;
		qrLog.error("TEST STATUS  =   	FAILED"+"                    ");
		qrLog.info("___________________________________________________");
		
		File imgFile = ((TakesScreenshot) baseLib.driver).getScreenshotAs(OutputType.FILE);
		System.out.println(imgFile.getAbsolutePath());
            try {
        	   
			FileUtils.copyFile(imgFile, new File(HouzifyBaseLib.sDirPath+"\\Reports\\ScreenShots\\"+sImage+"__"+sdate+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
       
            GenericLib.setStatus(result.getName().toString(), "Failed",sTestName,sStatus);
          
	}


	public void onTestSkipped(ITestResult result) 
	{
		qrLog.error("TEST STATUS  =   	SKIPPED"+"                    ");
		qrLog.info("___________________________________________________");
		GenericLib.setStatus(result.getName(), "Skipped",sTestName,sStatus);
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		qrLog.warn("");
		
	}


	public void onStart(ITestContext context) 
	{
		qrLog.info("######################     START OF THE TEST    ######################");
	}

	
	public void onFinish(ITestContext context) 
	{
		GenericLib.toWriteIntoExcel(sTestName,sStatus);
		qrLog.info("                                                                    ");
		qrLog.info("######################     END OF THE TEST    ######################");
		
	}
	

			
	
}
