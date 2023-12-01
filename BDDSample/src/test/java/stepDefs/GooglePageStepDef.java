package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GooglePageStepDef {
	WebDriver driver;
	
	@Given("User is on Google Home Page")
	public void user_is_on_google_home_page() {
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
	   
	}
	@When("User search Java Tutorial")
	public void user_search_java_tutorial() {
		WebElement srcBox= driver.findElement(By.tagName("textarea"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.submit();
	  
	}
	@Then("Should display Java Result Page")
	public void should_display_java_result_page() {
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	   
	}
	
	@When("User search Selenium Tutorial")
	public void user_search_selenium_tutorial() {
		WebElement srcBox= driver.findElement(By.tagName("textarea"));
		srcBox.sendKeys("Selenium Tutorial");
		srcBox.submit();
	}
	@Then("Should display Selenium Result Page")
	public void should_display_selenium_result_page() {
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search page");
	}

}
