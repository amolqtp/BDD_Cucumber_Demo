
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinations
{
	public static WebDriver driver = null;
	public int num1, num2, result;
	@Given("^I have first (\\d+) and second (\\d+) number$")
	public void i_have_first_and_second_number(int arg1, int arg2)
	{
		num1 = arg1;
		num2 = arg2;		
	}

	@When("^I perform addition operation$")
	public void i_perform_addition_operation()
	{
		result = num1 + num2;
	}

	@Then("^I should get correct (\\d+) result$")
	public void i_should_get_correct_result(int arg1)
	{
		org.junit.Assert.assertTrue(result == arg1);		
	}
	
	@Given("^I have open browser$")
	public void i_have_open_browser() {
		//set driver path for ie
		System.setProperty("webdriver.ie.driver", "C:\\softwares\\IEDriverServer.exe");			
		//initiate ie driver object
		driver = new InternetExplorerDriver();		
		//maximize window
		driver.manage().window().maximize();
		//set time limit of 60 seconds for page to load
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//set time limit of 20 seconds for objects to load/appear
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^I navigate to google site$")
	public void i_navigate_to_google_site(DataTable arg1) {		
		String url = arg1.raw().get(0).get(0);
		//navigate to google.co.in site
		driver.get(url);
	}

	@When("^I enter search & click on search button$")
	public void i_enter_search_click_on_search_button(DataTable arg1) {
		String text = arg1.raw().get(0).get(0);
		WebElement search_text = driver.findElement(By.id("lst-ib"));
		search_text.sendKeys(text);
	}

	
	@Then("^search result should display$")
	public void search_result_should_display(DataTable arg1) {
		String result = arg1.raw().get(0).get(0);
		org.junit.Assert.assertTrue(driver.getTitle().equalsIgnoreCase(result));		
	}
}
