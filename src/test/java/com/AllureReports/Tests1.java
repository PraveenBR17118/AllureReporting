package com.AllureReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import io.qameta.allure.*;


@Listeners({AllureListener.class})
public class Tests1 extends BaseClass 
{	
	public WebDriver driver;

	@BeforeClass
	public void setup() 
	{
		BaseClass b1 = new BaseClass();
		driver=b1.initialize_driver();
		driver.get("https://demo.nopcommerce.com/");
		//driver.manage().window().maximize();

	}

	@Severity(SeverityLevel.MINOR)	
	@Description("Verify Logo presence on Home Page........")
	@Epic("EP001")
	@Feature("Feature1: Logo")
	@Story("Story:Logo Presence")
	@Step("Verify logo Presence")
	@Test(priority=1, description="Verify Logo presence on Home Page")
	public void logoPresence() 
	{
		WebElement Logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		boolean dispstatus = Logo.isDisplayed();
		Assert.assertEquals(dispstatus, true);

	}

	@Severity(SeverityLevel.BLOCKER)	
	@Test(priority=2, description="Verify login")
	@Description("Verify login with Valid Credentials........")
	@Epic("EP001")
	@Feature("Feature2: Login")
	@Story("Story:Valid login")
	@Step("Verify login")
	public void loginTest() 
	{

		WebElement LogoLogin = driver.findElement(By.xpath("//a[@class='ico-login']"));
		LogoLogin.click();

		WebElement Email = driver.findElement(By.xpath("//input[@id='Email']"));
		Email.sendKeys("praveenbr.1991@gmail.com");

		WebElement Pwd = driver.findElement(By.xpath("//input[@id='Password']"));
		Pwd.sendKeys("PPrrkk@1718");

		WebElement Submit = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		Submit.click();

		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store.");
	}

	@Severity(SeverityLevel.NORMAL)	
	@Test(priority=3, description="Verify user Registration")
	@Description("Verify user Registration........")
	@Epic("EP001")
	@Feature("Feature3: Registration")
	@Story("Story:User registration")
	public void registrationTest() 
	{
		throw new SkipException("skipping this test");
	}

	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
