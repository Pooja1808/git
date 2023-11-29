package day10sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteDriverTest {
	WebDriver driver;
	
  /**
 * @throws MalformedURLException
 */
@Test
  public void test() throws MalformedURLException {
	  ChromeOptions options = new ChromeOptions();
	 // options.addArguments("--remote-allow-origins=*");
	  options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
	  //options.setCapability(CapabilityType.BROWSER_VERSION, "115");
	  
	  String strHub ="http://172.31.8.159:4444";
	  driver = new RemoteWebDriver(new URL(strHub), options);
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
	  driver.manage().window().maximize();
	  
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("Java Tutorial");
	  searchBox.submit();
	  System.out.println("Page Title is...." +driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
  }
}
