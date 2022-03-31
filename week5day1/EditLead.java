package assignment.week5day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends ProjectSpecificMethods{
	
	@Test(priority = 2,dependsOnMethods = "assignment.week5day1.CreateLead.createLead")
	public void editLead() {
		
		//enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemosalesManager");
		//enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		//click Login button
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();
		//click CRM/SFA linkText
		WebElement linkTextCRM = driver.findElement(By.linkText("CRM/SFA"));
		linkTextCRM.click();
		
		//click Leads
		WebElement leads = driver.findElement(By.linkText("Leads"));
		leads.click();
		
		//click on Create Lead from Side Menu
		WebElement createLead = driver.findElement(By.linkText("Create Lead"));
		createLead.click();
		
		//Enter mandatory fields to create lead
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		companyName.sendKeys("CTS");
		
		//Enter first name
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.sendKeys("Bhuvanesh");
		
		//Enter last name
		WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
		lastName.sendKeys("G");
		
		//Enter first name local
		WebElement firstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
		firstNameLocal.sendKeys("Bhuvi");
		
		//Enter Department
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("testing");
		
		//Enter Description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("sample description");
		
		//Enter mail
		WebElement primaryEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
		primaryEmail.sendKeys("bhuvicheck@gmail.com");
		
		//Select state/province
		WebElement provinceElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select province=new Select(provinceElement);
		province.selectByVisibleText("New York");
		
		//click on create lead submit button
		WebElement submitCreateLeadButton = driver.findElement(By.className("smallSubmit"));
		submitCreateLeadButton.click();
		
		//click on Edit
		driver.findElement(By.linkText("Edit")).click();
		
		//clear description
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		//fill important note text area
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("sample important note");
		
		//click on update button
		driver.findElement(By.className("smallSubmit")).click();
		
	
		//get title of the landing page
		System.out.println("The title is "+driver.getTitle());
		
	}

}
