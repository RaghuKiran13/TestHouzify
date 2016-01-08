package com.houzify.PO;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.List;
import java.util.UUID;

import org.apache.bcel.generic.Select;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;



import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewUserRegPO 
{
	AndroidDriver driver = null;
	public Logger qrLog = Logger.getLogger(this.getClass());
	static UUID uuid;

	
	public NewUserRegPO(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id ="com.houzify:id/loginButton")
	private WebElement eleLoginBtn;
	public WebElement getEleLoginBtn()
	{
		return eleLoginBtn;
	}

	@FindBy(id ="com.houzify:id/emailLoginEditText")
	private WebElement eleLoginEmailTxtFld;
	public WebElement getEleLoginEmailTxtFld()
	{
		return eleLoginEmailTxtFld;
	}

	@FindBy(id ="com.houzify:id/passwordEditText")
	private WebElement ElePasswordTxtFld;
	public WebElement getElePasswordTxtFld()
	{
		return ElePasswordTxtFld;
	}

	@FindBy(id ="com.houzify:id/passwordLoginEditText")
	private WebElement elePassLoginTxtFld;
	public WebElement getElePassLoginTxtFld()
	{
		return elePassLoginTxtFld;
	}
	
	@FindBy(id ="com.houzify:id/fnameEditText")
	private WebElement eleFLnameTxtFld;
	public WebElement getEleFLnameTxtFld()
	{
		return eleFLnameTxtFld;
	}
	
	@FindBy(id ="com.houzify:id/genderImage")
	private WebElement eleGenderDropdownLst;
	public WebElement getEleGenderDropdownLst()
	{
		return eleGenderDropdownLst;
	}
	
	@FindBy(name="Male")
	private WebElement eleMaleItm;
	public WebElement getEleMaleItm()
	{
		return eleMaleItm;
	}
	
	@FindBy(name="SIGNUP")
	private WebElement eleSignUpBtn;
	public WebElement getEleSignUpBtn()
	{
		return eleSignUpBtn;
	}
	
	@FindBy(name="City")
	private WebElement eleCityTxtFld;
	public WebElement getEleCityTxtFld()
	{
		return eleCityTxtFld;
	}
	
	@FindBy(name="LET'S GO!")
	private WebElement eleLetGoBtn;
	public WebElement getEleLetGoBtn()
	{
		return  eleLetGoBtn;
	}
	
	@FindBy(id="com.houzify:id/userImage")
	private WebElement eleUploadeImg;
	public WebElement getEleUploadeImg()
	{
		return  eleUploadeImg;
	}
	
	@FindBy(name="Camera")
	private WebElement eleCameraBtn;
	public WebElement getEleCameraBtn()
	{
		return eleCameraBtn;
	}
	@FindBy(name="Camera")
	private WebElement eleCameraIcn;
	public WebElement getEleCameraIcn()
	{
		return eleCameraIcn;
	}
	@FindBy(id="com.android.camera2:id/photo_video_button")
	private WebElement eleNexusCameraBtn;
	public WebElement getEleNexusCameraBtn()
	{
		return eleNexusCameraBtn;
	}
	
	@FindBy(id="com.houzify:id/save")
	private WebElement eleSaveBtn;
	public WebElement getEleSaveBtn()
	{
		return eleSaveBtn;
	}
		
	@FindBy(id="com.android.camera2:id/done_button")
	private WebElement eleNexusDoneBtn;
	public WebElement getEleNexusDoneBtn()
	{
		return  eleNexusDoneBtn;
	}
	
	@FindBy(name="CONNECT WITH FACEBOOK")
	private WebElement eleConnectFBBtn;
	public WebElement getEleConnectFBBtn()
	{
		return eleConnectFBBtn;
	}
	
	@FindBy(id="com.houzify:id/googleButton")
	private WebElement eleGoogleBtn;
	public WebElement getEleGoogleBtn()
	{
		return eleGoogleBtn;
	}
	
	@FindBy(id="com.google.android.gms:id/account_profile_picture")
	private WebElement eleGmailProfileSelectBtn;
	public WebElement getEleGmailProfileSelectBtn()
	{
		return eleGmailProfileSelectBtn;
	}
	
	@FindBy(name="Allow")
	private WebElement eleAllowBtn;
	public WebElement getEleAllowBtn()
	{
		return eleAllowBtn;
	}
		
	@FindBy(name ="Gallery")
	private WebElement eleGalleryIcn;
	public WebElement getEleGalleryIcn()
	{
		return eleGalleryIcn;
	}
		
	@FindBy(id ="com.houzify:id/image")
	private WebElement eleGalleryBtn;
	public WebElement getEleGalleryBtn()
	{
		return eleGalleryBtn;
	}
	
	@FindBy(id="com.sonyericsson.android.camera:id/main_button")
	private WebElement eleSonyCameraBtn;
	public WebElement getEleSonyCameraBtn()
	{
		return eleSonyCameraBtn;
	}
	
	@FindBy(id="identifierId")
	private WebElement eleGmailIDTxtFld;
	public WebElement getEleGmailIDTxtFld()
	{
		return eleGmailIDTxtFld;
	}
	@FindBy(id="password")
	private WebElement eleGmailPwdTxtFld;
	public WebElement getEleGmailPwdTxtFld()
	{
		return eleGmailPwdTxtFld;
	}
		
	@FindBy(id="com.motorola.camera:id/review_approve")
	private WebElement eleMotoTickBtn;
	public WebElement getEleMotoTickBtn()
	{
		return  eleMotoTickBtn;
	}

	@FindBy(id="com.huawei.camera:id/btn_done")
	private WebElement eleHuaweiDoneBtn;
	public WebElement getEleHuaweiDoneBtn()
	{
		return eleHuaweiDoneBtn;
	}
	
	@FindBy(id="com.houzify:id/emailEditText")
	private WebElement eleSignUpEmailTxt;
	public WebElement getEleSignUpEmailTxt()
	{
		return eleSignUpEmailTxt;
	}
	
	@FindBy(name="Photos")
	private WebElement eleGooglePhotosBtn;
	public WebElement getEleGooglePhotosBtn()
	{
		return eleGooglePhotosBtn;
	}
	
	@FindBy(name="Always")
	private WebElement eleGoogleDoneBtn;
	public WebElement getEleGoogleDoneBtn()
	{
		return eleGoogleDoneBtn;
	}
	
	@FindBy(name="Camera")
	private WebElement eleSetCameraBtn;
	public WebElement getEleSetCameraBtn()
	{
		return eleSetCameraBtn;
	}
	@FindBy(id="com.google.android.apps.photos:id/list_photo_tile_view")
	private WebElement eleSelectPhotonBtn;
	public WebElement getEleSelectPhotonBtn()
	{
		return eleSelectPhotonBtn;
	}
	
	
	//New User registeration uploading profile pic from camera
	public void signUpUploadCameraImg(String sFullname,String sCity,String sPassword, HomePO homePo, String sDeviceName) throws InterruptedException
	{
		String sEmail = "testHouzify"+uuid.randomUUID().toString()+"@gmail.com";
		getEleSignUpBtn().click();
		getEleFLnameTxtFld().sendKeys(sFullname);
		getEleGenderDropdownLst().click();
		getEleMaleItm().click();
		getEleCityTxtFld().sendKeys(sCity);
		getEleSignUpEmailTxt().sendKeys(sEmail);
		getElePasswordTxtFld().sendKeys(sPassword);
		Assert.assertTrue(getEleUploadeImg().isDisplayed(), "Uploadimage icon is not dispayed");
		qrLog.info("uploadimage icon is displayed");
		getEleUploadeImg().click();
		getEleCameraBtn().click();
		cameraDefault(sDeviceName, homePo);
	}
	
	//New User registeration uploading profile pic from Gallery
 	public void signUpWithGalleryImg(String sFullname,String sCity,String sPassword) throws InterruptedException
	{
 		String sEmail = "testHouzify"+uuid.randomUUID().toString()+"@gmail.com";
		try
		{
			if(getEleSignUpBtn().isDisplayed())
			{	
				Assert.assertTrue(getEleSignUpBtn().isDisplayed(),"Signup Button is not displayed");
				qrLog.info("Sign Up button and signup registration page is displayed");
				
				//SignUp for new User
				getEleSignUpBtn().click();
				getEleFLnameTxtFld().sendKeys(sFullname);
				eleGenderDropdownLst.click(); 
				getEleMaleItm().click();
				getEleCityTxtFld().sendKeys(sCity); 
				getEleSignUpEmailTxt().sendKeys(sEmail);
				getElePasswordTxtFld().sendKeys(sPassword); 
				getEleUploadeImg().click(); 
				
				//Verification of the gallery app existence
				Assert.assertTrue(getEleGalleryIcn().isDisplayed(), "Gallery app is not dispayed");
				qrLog.info("Gallery app should be displayed");
				getEleGalleryIcn().click();
				googlePhotos();
			}
		}
		catch(Exception e)
			{	qrLog.error("Exception at signUpWithGalleryImg()"); 
				e.getStackTrace();
				Assert.fail();
			}
	}
	
 	// Login with invalid credentials
	public void invalidLogin(String sEmail, String sPassword, MyProfilePO myProfilePo)
	{
		try{
			if(getEleLoginBtn().isDisplayed())
			{			
				Assert.assertTrue(getEleLoginBtn().isDisplayed(), "Login screen is not displayed");
				qrLog.info("Login screen of Houzify is successfully displayed");
				getEleLoginBtn().click();
				getEleLoginEmailTxtFld().sendKeys(sEmail);
				getElePassLoginTxtFld().sendKeys(sPassword);
				myProfilePo.getEleLetMeInBtn().click();
				
				Assert.assertTrue(myProfilePo.getEleLetMeInBtn().isDisplayed(), "Failure as Login is Successful");
				qrLog.info("Failed to Login, Please filled all the details");
				Thread.sleep(5000);
			}
		}catch(Exception e)
		{
			qrLog.error("Exception at invalidLogin()");
			e.getStackTrace();
			Assert.fail();
		}	
	}
	// Login with FaceBook credentials
	public void facebookLogin()
	{	try
		{
			if(getEleLoginBtn().isDisplayed())
			{	
				Assert.assertTrue(getEleLoginBtn().isDisplayed(),"Login Button is not displayed");
				qrLog.info("Login button and signup registration page is displayed");
				getEleLoginBtn().click();
				Assert.assertTrue(getEleConnectFBBtn().isDisplayed(),"FaceBook button is not displayed");
				qrLog.info("Facebook button is displayed");
				getEleConnectFBBtn().click();
			}
		}
		catch(Exception e)
		{	qrLog.error("Exception at facebookLogin");
			e.getStackTrace();
			Assert.fail();
		}
	}
	// Login with Google credentials
	public void googleLogin()
	{
		try
		{	if(getEleLoginBtn().isDisplayed())
			{	qrLog.info("Login page is displayed");
				getEleLoginBtn().click();
				
				Assert.assertTrue(getEleGoogleBtn().isDisplayed(),"Google button is not displayed");
				qrLog.info("Google button is displayed");
				getEleGoogleBtn().click();
				getEleGmailProfileSelectBtn().click();
				getEleAllowBtn().click();
				getEleAllowBtn().click();
				
			}
	}catch(Exception e)
	{
		qrLog.error("Exception at googleLogin");
		e.getStackTrace();
		Assert.fail();
	}
	}
	
	//New User registration  without updloading profile pic
	public void newUserSignup(String sFullname,String sCity,String sPassword)
	{
		String sEmail = "testHouzify"+uuid.randomUUID().toString()+"@gmail.com";
		try
		{			
			if(getEleSignUpBtn().isDisplayed())
			{	
				Assert.assertTrue(getEleSignUpBtn().isDisplayed(),"Signup Button is not displayed");
				qrLog.info("Sign Up button and signup registration page is displayed");
				
				getEleSignUpBtn().click();
				getEleFLnameTxtFld().sendKeys(sFullname);
				getEleGenderDropdownLst().click(); 
				getEleMaleItm().click();
				getEleCityTxtFld().sendKeys(sCity); 
				getEleSignUpEmailTxt().sendKeys(sEmail); 
				getElePasswordTxtFld().sendKeys(sPassword); 
							
				Assert.assertTrue(getEleUploadeImg().isDisplayed(), "Uploadimage icon is not dispayed");
				qrLog.info("uploadimage icon should be displayed");
			}
			Thread.sleep(2000);
			getEleLetGoBtn().click();
		}
		catch(Exception e)
		{
			qrLog.error("Exception at newUserSignup");
			e.getStackTrace();
			Assert.fail();
		}
	}
	//Uploading photos.
	public void googlePhotos() throws InterruptedException
	{
		FilterPO filterPo = new FilterPO(driver);
		try{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(getEleCameraIcn().isDisplayed())
			{
				try{
					getEleCameraIcn().click();
					Thread.sleep(20000);
					getEleSelectPhotonBtn().click();
					getEleSaveBtn().click();
					Thread.sleep(2000);
					getEleLetGoBtn().click();
					Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Signup is not successful");
					qrLog.info("User SignUp is successful");
					}
				catch(Exception e)
					{
						getEleGooglePhotosBtn().click();
						getEleGoogleDoneBtn().click();
						Thread.sleep(10000);
						getEleCameraIcn().click();
						Thread.sleep(20000);
						getEleSelectPhotonBtn().click();
						getEleSaveBtn().click();
						Thread.sleep(2000);
						getEleLetGoBtn().click();
						Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Signup is not successful");
						qrLog.info("User SignUp is successful");
				}
			}
		}
		catch(Exception e)
		{
			qrLog.error("Error in googlePhotos ");
			Assert.fail();
		}
	}
	// To set camera as default
	public void cameraDefault(String sDeviceName, HomePO homePo)
	{	FilterPO filterPo = new FilterPO(driver);
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if(getEleSetCameraBtn().isDisplayed())
			{
				getEleSetCameraBtn().click();
				getEleGoogleDoneBtn().click();
				switch(sDeviceName)
				{
				case "Nexus 5":
					try
					{							
						//Lg nexus 5
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						if(getEleNexusCameraBtn().isDisplayed()){
							getEleNexusCameraBtn().click();
							getEleNexusDoneBtn().click();
							getEleSaveBtn().click();
							Thread.sleep(2000);
							getEleLetGoBtn().click();
							Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Signup is not successful");
							qrLog.info("User SignUp is successful");
							Thread.sleep(4000);
							homePo.swipeHomeImg(20);
						}
					}catch(Exception e)
					{
						qrLog.error("Exception at signUpUploadCameraImg");
					
					}
							break;
				case "XT1068":
					try
					{	//Moto G2
						driver.tap(1, 351,640, 1);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						getEleMotoTickBtn().click();
						getEleSaveBtn().click();
						Thread.sleep(2000);
						getEleLetGoBtn().click();
						Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Signup is not successful");
						qrLog.info("User SignUp is successful");
						homePo.swipeHomeImg(20);
					}catch(Exception e)
					{
						qrLog.error("Exception at signUpUploadCameraImg");
						
					}
					break;
				case "C6602":
					try
					{
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						getEleSonyCameraBtn().click();
						getEleSaveBtn().click();
						Thread.sleep(2000);
						getEleLetGoBtn().click();
						Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Signup is not successful");
						qrLog.info("User SignUp is successful");
						Thread.sleep(4000);
						homePo.swipeHomeImg(20);
						
					}
					catch(Exception e)
					{
						qrLog.error("Exception at signUpUploadCameraImg");
					}
					break;
				
				 default:
					 qrLog.error("Unable to Identify the device connected, Please connect the device specified above");
					}
				
				}
			}
		catch(Exception e)
		{
			qrLog.error("Failed to select camera");
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		switch(sDeviceName)
		{
		case "Nexus 5":
			try
				{	//Lg nexus 5
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if(getEleNexusCameraBtn().isDisplayed())
					{
						getEleNexusCameraBtn().click();
						getEleNexusDoneBtn().click();
						getEleSaveBtn().click();
						Thread.sleep(2000);
						getEleLetGoBtn().click();
						Assert.assertTrue(filterPo.getEleMenuIcn().isDisplayed(), "User Signup is not successful");
						qrLog.info("User SignUp is successful");
						Thread.sleep(4000);
						homePo.swipeHomeImg(20);
					}
				}
			catch(Exception e)
				{
					qrLog.error("Exception at signUpUploadCameraImg");
					
				}
				break;
			case "XT1068":
				try
				{	//Moto G2
					driver.tap(1, 351,640, 1);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					getEleMotoTickBtn().click();
					getEleSaveBtn().click();
					Thread.sleep(2000);
					getEleLetGoBtn().click();
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					homePo.swipeHomeImg(20);
				}catch(Exception e)
				{
					qrLog.error("Exception at signUpUploadCameraImg");
				}
				break;
			case "C6602":
				try
				{	//Sony
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					getEleSonyCameraBtn().click();
					getEleSaveBtn().click();
					Thread.sleep(2000);
					getEleLetGoBtn().click();
					Thread.sleep(4000);
					homePo.swipeHomeImg(20);
					System.out.println("Swipe");
				}
				catch(Exception e)
				{
					qrLog.error("Exception at signUpUploadCameraImg");
				}break;
				
			 default:
				 qrLog.error("Unable to Identify the device connected, Please connect the device specified above");
			}
			
	}
	//User Login
	public void login(String sEmailId, String sPwd, MyProfilePO myProfilePo)
	{
		try
		{
			getEleLoginBtn().click();
			getEleLoginEmailTxtFld().sendKeys(sEmailId);
			getElePassLoginTxtFld().sendKeys(sPwd);
			myProfilePo.getEleLetMeInBtn().click();
		}
		catch(Exception e)
		{
			qrLog.info("Failed at login()");
			Assert.fail();
		}
	}
}
		
