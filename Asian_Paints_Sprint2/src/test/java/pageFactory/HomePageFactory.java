package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	
	
	@FindBy(id="headerSearch")
	WebElement selectSearchTab;
	
	@FindBy(name="q")
	WebElement enterProduct;
	
	@FindBy(xpath = "//button[@class='js-header-search-handle']")
	WebElement selectSearchBtn;
	
	@FindBy(xpath = "//h4[@class='report-title']")
	WebElement selectProduct;
	
	@FindBy(xpath = "//input[@class='commonTextComp track_search_click']")
	WebElement invalidProduct;
	
	@FindBy(xpath = "//div[@class='headerDropdown']")
	WebElement selectDropDown;
	
	@FindBy(xpath = "//div[@class='no-results-content__text-block text']")
	WebElement errorMessage;
	
	
	WebDriver driver;
	
	public HomePageFactory(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSearchTab()
	{
		selectSearchTab.click();
	
	}
	
	public void enterProduct(String prod)
	{
		enterProduct.sendKeys(prod);
	}
	
	public void clickSearchBtn()
	{
		selectSearchBtn.click();
	}
	
	public void clickProduct()
	{
		selectProduct.click();
	}
	
	public void enterInvalidProd(String prod)
	{
		invalidProduct.sendKeys(prod);
	}
	
	public String dispTitle()
	{
		return driver.getTitle();
	}
	
	public void clickDropDown()
	{
		selectDropDown.click();
	}
	
	public String dispError()
	{
		return errorMessage.getText();
	}
	
	public void endScenario()
	{
		driver.quit();
	}
	public void selectUserType(String user)
	{
		driver.findElement(By.linkText(user)).click();
	}
}
