// This module is used to validate that the customer will be able to get confirmation dialog box

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;


public class Admin_Home_Page {
	 WebDriver driver;
	 
  @Test(priority=1)
  
  public void test() {
	 
	  /*String expTitle="Cyclos";
	  String actTitle=driver.getTitle();
	  //assertEquals(actTitle, expTitle);
	  //expTitle=". Login";
	 // actTitle=driver.getTitle();*/	
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//input[@id='cyclosUsername']")).sendKeys("admin");
	
	 driver.findElement(By.xpath("//input[@value='1']")).click();
	 driver.findElement(By.xpath("//input[@value='2']")).click();
	 driver.findElement(By.xpath("//input[@value='3']")).click();
	 driver.findElement(By.xpath("//input[@value='4']")).click();
	 driver.findElement(By.xpath("//input[@value='Submit']")).click();
	 driver.findElement(By.id("memberUsername")).sendKeys("pinkubhui");
  }
	// driver.findElement(By.id("membername")).sendKeys("pinkubhui");
	 
@Test(priority=2)
public void personal() throws AWTException, InterruptedException
{
	 Robot robot = new Robot();
	 Thread.sleep(3000);
	 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	 Thread.sleep(3000);
	 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	 Thread.sleep(3000);
	 
}
@Test(priority = 3)
public void payment() throws InterruptedException{
	 driver.findElement(By.xpath("//input[@linkurl='payment?to=3']")).click();
	 driver.findElement(By.xpath("//input[@value='pinkubhui']")).click();
	driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("100");
	Thread.sleep(3000);
	 Select Transactiontype=new Select(driver.findElement(By.id("type")));
	 Transactiontype.selectByVisibleText("Community to member");
	driver.findElement(By.id("description")).sendKeys("displays the transaction confirmation dialogue box");
	 driver.findElement(By.xpath("//input[@value='Submit']")).click();
	 driver.findElement(By.xpath("//input[@value='Submit']")).click();
	 driver.findElement(By.xpath("//input[@value='Back']")).click();
	driver.findElement(By.xpath("//input[@value='Back']")).click();
	 
	 String expected = "Payment system to member";
	 WebElement res = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
	 String actual = res.getText();
	 System.out.println(actual);
	 assertEquals(actual, expected);
  } 

  

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("http://localhost:8585/do/admin/home?fromMenu=true");
  }
  @AfterClass
  public void afterClass()
  {
	// driver.close(); 
  }
	  
  

 
}
