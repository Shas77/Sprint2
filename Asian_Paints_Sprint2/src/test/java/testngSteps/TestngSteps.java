package testngSteps;

import org.testng.annotations.Test;

import com.libraries.ExcelUtility;
import com.libraries.Utility;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pageFactory.HomePageFactory;

public class TestngSteps {

	public WebDriver driver;
	public HomePageFactory homepf;
	public ExcelUtility excelUtil = new ExcelUtility();
	public Utility util = new Utility();

	@BeforeMethod
	public void launchApplication() throws Exception
	{
		System.setProperty(util.getWebDriver(), util.getExecutor());
		driver=new ChromeDriver();
		homepf=PageFactory.initElements(driver, HomePageFactory.class);
		driver.manage().window().maximize();
		driver.get(util.getBaseUrl());
	
	}
	
	@DataProvider(name = "excelData1")
	public Object[] testData1() throws Exception
	{
		Object[] obj = excelUtil.getData(util.getExcelSheetPath1(), util.getExcelSheetName1());
		return obj;
	}
	
	@DataProvider(name = "excelData2")
	public Object[] testData2() throws Exception
	{
		Object[] obj = excelUtil.getData(util.getExcelSheetPath1(), util.getExcelSheetName2());
		return obj;
	}

	@Test(priority = 1, dataProvider = "excelData1")
	public void SearchProduct(String productName) throws Exception 
	{
		homepf.clickSearchTab();
		homepf.enterProduct(productName);
		homepf.clickSearchBtn();
		homepf.clickProduct();
		String expectedTitle=homepf.dispTitle();
		System.out.println(expectedTitle);
	}
	
	@Test(priority = 2, dataProvider = "excelData2")
	public void SearchInvalidProduct(String productName) throws Exception 
	{
		homepf.clickSearchTab();
		homepf.enterProduct(productName);
		homepf.clickSearchBtn();
		String expectedMessage = homepf.dispError();
		String actualMessage = util.getActualMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println("Verified message is: "+expectedMessage);
	}


	@AfterMethod
	public void endTest()
	{
		homepf.endScenario();
	}
}
