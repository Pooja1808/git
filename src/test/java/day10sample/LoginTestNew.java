package day10sample;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.checkerframework.common.value.qual.ArrayLen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTestNew {
	WebDriver driver;
	Properties prop;
	
@BeforeMethod
	private void setUP() {
		// TODO Auto-generated method stub
		prop = new Properties();
		String path = System.getProperty("user.dir")
				+ "//src//test//resources//configFiles//config.properties";
	}
	
  @Test
  public void validLogin() {
	  
	  driver.get(prop.getProperty("url"));
	  driver.findElement(By.id("username")).sendKeys(strUser);;
	  driver.findElement(By.name("username")).sendKeys(strUser);;

  }

 @DataProvider(name="loginData")
 public Object[][] getData() throws CsvValidationException, IOException
 {
	// String path = System.getProperty("user.dir") + 
		//	 "//src//test//resources//testdata//loginData.csv";
	 //CSVReader reader = new CSVReader(new FileReader(path));
	 //String str[];
	 ArrayList<Object> dataList = new ArrayList<Object>();
	 while(str = reader.readNext()!=null)
	 {
		 Object[] record = {str[0], str[1]};
		 dataList.add(record);
	 }
 reader.close();
 return dataList.toArray();
 }



}
