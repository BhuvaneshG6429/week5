package assignment.week5day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends ProjectSpecificMethods{
	
	@Test(invocationCount = 2,priority = 1, alwaysRun = true)
	public void createLead() {
				WebElement username = driver.findElement(By.id("username"));
				username.sendKeys("DemosalesManager");
				WebElement password = driver.findElement(By.id("password"));
				password.sendKeys("crmsfa");
				WebElement login = driver.findElement(By.className("decorativeSubmit"));
				login.click();
				WebElement linkTextCRM = driver.findElement(By.linkText("CRM/SFA"));
				linkTextCRM.click();
				WebElement leads = driver.findElement(By.linkText("Leads"));
				leads.click();
				WebElement createLead = driver.findElement(By.linkText("Create Lead"));
				createLead.click();
				WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
				companyName.sendKeys("CTS");
				WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
				firstName.sendKeys("Bhuvanesh");
				WebElement lastName = driver.findElement(By.id("createLeadForm_lastName"));
				lastName.sendKeys("G");
				WebElement firstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
				firstNameLocal.sendKeys("Bhuvi");
				driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("testing");
				driver.findElement(By.id("createLeadForm_description")).sendKeys("sample description");
				driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("0000000001");
				WebElement primaryEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
				primaryEmail.sendKeys("bhuvicheck@gmail.com");
				WebElement provinceElement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
				Select province=new Select(provinceElement);
				province.selectByVisibleText("New York");
				WebElement submitCreateLeadButton = driver.findElement(By.className("smallSubmit"));
				submitCreateLeadButton.click();
				System.out.println("The title is "+driver.getTitle());
	}

}
