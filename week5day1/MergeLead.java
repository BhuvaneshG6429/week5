package assignment.week5day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead extends ProjectSpecificMethods{
	
	@Test(priority = 5, dependsOnMethods = "assignment.week5day1.DuplicateLead.duplicateLead")
	public void MergeLead() {
		
				//Enter UserName and Password Using Id Locator
				
				WebElement username = driver.findElement(By.id("username"));
				username.sendKeys("DemosalesManager");
				
				WebElement password = driver.findElement(By.id("password"));
				password.sendKeys("crmsfa");
				
				
				//Click on Login Button using Class Locator
				driver.findElement(By.className("decorativeSubmit")).click();
				
				//Click on CRM/SFA Link
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				//Click on contacts Button
				driver.findElement(By.linkText("Leads")).click();
				
				//Click on Merge Contact
				driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
				
				//Click on Widget of From Contact
				WebElement fromWidget = driver.findElement(By.xpath("//span[text()='From Lead']//following::a[1]"));
				fromWidget.click();
				  
				//Click on First Resulting Contact
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> list = new ArrayList<String>(windowHandles);
				driver.switchTo().window(list.get(1));
				
				WebElement firstRowValue = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//a[1]"));
				String firstRowText = firstRowValue.getText();
				firstRowValue.click();
				driver.switchTo().window(list.get(0));
				
				String fromLeadValue = driver.findElement(By.xpath("//input[@id='ComboBox_partyIdFrom']")).getAttribute("value");
				Assert.assertEquals(firstRowText, fromLeadValue);
				
				//Click on Widget of To Contact
				WebElement toWidget = driver.findElement(By.xpath("//span[text()='To Lead']//following::a[1]"));
				toWidget.click();
				  
				//Click on Second Resulting Contact
				Set<String> windowHandles1 = driver.getWindowHandles();
				List<String> list1 = new ArrayList<String>(windowHandles1);
				driver.switchTo().window(list1.get(1));
				
				WebElement secondRowValue = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//a[1]"));
				String secondRowText = secondRowValue.getText();
				secondRowValue.click();
				driver.switchTo().window(list.get(0));
				
				String toLeadValue = driver.findElement(By.xpath("//input[@id='ComboBox_partyIdTo']")).getAttribute("value");
				Assert.assertEquals(secondRowText, toLeadValue);
				  
				//Click on Merge button using Xpath Locator
				  driver.findElement(By.xpath("//form[@name='MergePartyForm']//child::a[text()='Merge']")).click();
				//Accept the Alert
				  
				 Alert alert = driver.switchTo().alert();
				 alert.accept();
				 
				//Verify the title of the page
				 
				Assert.assertEquals(driver.getTitle(), "View Lead | opentaps CRM");

	}

}
