/***********************************************************************
* @author 			:		LAKSHMI BS
* @description		: 		Generic library with reusable methods that can be used across porjects.
* @method			:		getCongigValue()
* @method			:		toReadExcelData()
* @method			:		toWriteIntoExcel()
* @method 			:		setStatus()
* @method 
*/

package com.houzify.baselib;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;



import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class GenericLib 
{
	public static String sTestDataFile=HouzifyBaseLib.sDirPath+"\\TestData.xlsx";
	public static String sFile=HouzifyBaseLib.sDirPath+"\\Reports\\Results\\TestResult_"; 
	public static int iPassCount=0;
	public static int iFailCount=0;
	public static int iSkippedCount=0;
	public static String sSheet1="Results";
	public static String sSheet2="Test Status";
	
	
	/*@author: LAKSHMi BS
	 *Description: To read the basic environment settings data from config file
	 */
	public static String getCongigValue(String sFile, String sKey)
	{
		Properties prop = new Properties();
		String sValue=null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue=prop.getProperty(sKey);
			
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
		
		return sValue;
		
		
	}
	/*
	 * @author: LAKSHMI BS
	 * Description: To read test data from excel sheet
	 */
	public static String[] toReadExcelData(String sTestCaseID)
	{
		String sData[]=null;
		try
		{
		
		FileInputStream fis = new FileInputStream(sTestDataFile);
		Workbook wb = (Workbook) WorkbookFactory.create(fis);
		
		Sheet sht = wb.getSheet("QR_TestData");
		int iRowNum= sht.getLastRowNum();
		
		int k=0;
	
		for(int i=1;i<=iRowNum;i++)
		{
			
			if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
			{
				int iCellNum=sht.getRow(i).getLastCellNum();
				sData= new String[iCellNum];
				for(int j=0;j<iCellNum;j++)		
				{
					sData[j]=sht.getRow(i).getCell(j).getStringCellValue();
									
				}
				break;
				
			}
		}	
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		return sData;
		}

	/*
	 * @author: LAKSHMI BS
	 * Description: To write test results into excel sheet
	 */
	public  static void toWriteIntoExcel(ArrayList sTestName, ArrayList sStatus )
	{
		try
		{

		FileInputStream fis = new FileInputStream(sFile);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sht = wb.getSheet("Test Status");
		
		sht.createRow(0);
		sht.getRow(0).createCell(0).setCellValue("TestName");
		sht.getRow(0).createCell(1).setCellValue("Status");
		
		int j=1;
		for(int i=0;i<sTestName.size();i++)
		{
			sht.createRow(j);
			sht.getRow(j).createCell(0).setCellValue((String)sTestName.get(i));
			sht.getRow(j).createCell(1).setCellValue((String)sStatus.get(i));
			j++;
		}
		
		Sheet sht2 = wb.getSheet("Results");
		sht2.createRow(0).createCell(0).setCellValue("Result Summary");
		
		sht2.createRow(1).createCell(0).setCellValue("Passed");
		sht2.getRow(1).createCell(1).setCellValue(iPassCount);
		
		sht2.createRow(2).createCell(0).setCellValue("Failed");
		sht2.getRow(2).createCell(1).setCellValue(iFailCount);
		
		sht2.createRow(3).createCell(0).setCellValue("Skipped");
		sht2.getRow(3).createCell(1).setCellValue(iSkippedCount);
		
		sht2.createRow(5).createCell(0).setCellValue("Total Executed");
		sht2.getRow(5).createCell(1).setCellValue(iPassCount+iFailCount+iSkippedCount);
		
		
		FileOutputStream fos = new FileOutputStream(sFile);
		wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * @author: LAKSHMI BS
	 * Description: To set status of every testcases with its execution results
	 */
	public  static void setStatus(String sName, String sResult,ArrayList sTestName, ArrayList sStatus)
	{
		sName=sName.replace("test","");
		sTestName.add(sName);
		sStatus.add(sResult);
		
		if(sResult.equals("Passed"))
		{
			iPassCount=iPassCount+1;
			
		}else if(sResult.equals("Failed"))
		{
			iFailCount = iFailCount+1;
		}
		else
		{
			iSkippedCount = iSkippedCount+1;
			
		}
			
		
	}

}