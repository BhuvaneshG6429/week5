package assignment.week5day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends ProjectSpecificMethods{
	
	@Test(priority = 4, dependsOnMethods = "assignment.week5day1.CreateLead.createLead")
	public void DeleteLead() throws InterruptedException {
	
		//Enter the username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemosalesManager");
		//Enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		//Click Login
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();
		//Click crm/sfa link
		WebElement linkTextCRM = driver.findElement(By.linkText("CRM/SFA"));
		linkTextCRM.click();
		//Click Leads link
		WebElement leads = driver.findElement(By.linkText("Leads"));
		leads.click();
		//Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//Enter phone number
		driver.findElement(By.name("phoneNumber")).sendKeys("0000000001");
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		//Capture lead ID of First Resulting lead
		WebElement leadIDFirstElement = driver.findElement(By.xpath("(//span[contains(text(),'Lead List')]//following::a[@class='linktext'])[1]"));
		String leadID = leadIDFirstElement.getText();
		
		//Click First Resulting lead
		leadIDFirstElement.click();
		//Click Delete
		driver.findElement(By.linkText("Delete")).click();
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		//Enter captured lead ID
		driver.findElement(By.xpath("//span[text()='Name and ID']/following::input[@name='id']")).sendKeys(leadID);
		//Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement pageInfo = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		String verificationMessage = pageInfo.getText();
		System.out.println("Verification message is "+verificationMessage);
		if(verificationMessage.equals("No records to display")) {
			System.out.println("verified the Lead is deleted");
		}
		else {
			System.out.println("Lead is not deleted");
		}
		
	}

}
