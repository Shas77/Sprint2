package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePageFactory;

public class HomePage {
	
	String baseUrl="https://www.asianpaints.com/";
	WebDriver driver;
	HomePageFactory homepf;
	
	
	@Given("user is in the home page of Asian Paints")
	public void user_is_in_the_home_page_of_Asian_Paints() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe\\");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		homepf=PageFactory.initElements(driver, HomePageFactory.class);
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
	    System.out.println("Product displayed");
	}

	@When("user enters the search as {string}")
	public void user_enters_the_search_as(String product) 
	{
	    homepf.enterInvalidProd(product);
	}

	@Then("the invalid search message is displayed")
	public void the_invalid_search_message_is_displayed()
	{
		System.out.println("Invalid Search");
	}
	
	//User types
	 
	@Given("the user is in the home page of Asian Paints")
	public void the_user_is_in_the_home_page_of_asian_paints() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver.exe\\");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		homepf=PageFactory.initElements(driver, HomePageFactory.class);
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
	   System.out.println("Driver navigated to the page");
	}


}
