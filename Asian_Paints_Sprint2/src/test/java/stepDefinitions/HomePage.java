package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePageFactory;

public class HomePage {
	
	
	HomePageFactory homepf;
	
	@Before
	public void launchApplication() throws IOException
	{
		Properties property=new Properties();
		FileInputStream input=new FileInputStream("src\\test\\resources\\Properties\\Config.properties");
		property.load(input);
		String driverPath=property.getProperty("driverPath");
		System.setProperty("webdriver.chrome.driver", driverPath);
		String baseUrl=property.getProperty("baseUrl");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		homepf=PageFactory.initElements(driver, HomePageFactory.class);
		
	}
	
	
	
	@Given("user is in the home page of Asian Paints")
	public void user_is_in_the_home_page_of_Asian_Paints() throws IOException 
	{
		launchApplication();
		String actualTitle="Wall Paints, Home Painting & Paint Colour Combinations in India - Asian Paints";
		String expectedTitle=homepf.dispTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Verified");
		
	}
	
	@When("the user clicks on search")
	public void the_user_clicks_on_search() 
	{
	    homepf.clickSearchTab();
	}

	@When("user enters the search item as {string}")
	public void user_enters_the_search_item_as(String product) 
	{
	    homepf.enterProduct(product);
	}

	@Then("user clicks the search button")
	public void user_clicks_the_search_button()
	{
	    homepf.clickSearchBtn();
	}

	@Then("user selects the product")
	public void user_selects_the_product() 
	{
	    homepf.clickProduct();
	}

	@Then("the products are displayed")
	public void the_products_are_displayed() 
	{
	    System.out.println(homepf.dispTitle());
	}

	@When("user enters the search as {string}")
	public void user_enters_the_search_as(String product) 
	{
	    homepf.enterInvalidProd(product);
	}

	@Then("the invalid search message is displayed")
	public void the_invalid_search_message_is_displayed()
	{
		
		String expectedError=homepf.dispError();
		String actualError="Sorry, there seem to be no results matching your search.\n"
				+ "Would you want to try some of our popular search terms from below?";
		Assert.assertEquals(actualError, expectedError);
		System.out.println(expectedError);
		
	}
	
	//User types
	 
	@Given("the user is in the home page of Asian Paints")
	public void the_user_is_in_the_home_page_of_asian_paints() throws IOException 
	{
		launchApplication();
		String homePageTitle="Wall Paints, Home Painting & Paint Colour Combinations in India - Asian Paints";
		String expectedTitle=homepf.dispTitle();
		AssertJUnit.assertEquals(homePageTitle,expectedTitle);
		System.out.println("Verified");
	}

	@Given("user clicks the dropdown in the header")
	public void user_clicks_the_dropdown_in_the_header() 
	{
	    homepf.clickDropDown();
	}

	@Given("user selects the type as {string}")
	public void user_selects_the_type_as(String user) {
		homepf.selectUserType(user);
	}

	@Then("user is navigated to that page")
	public void user_is_navigated_to_that_page()
	{
	   System.out.println(homepf.dispTitle());
	}

	@After
	public void endScene()
	{
		homepf.endScenario();
	}
	

}
