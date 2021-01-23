package com.TestCases; 

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.Page.Employeelistpage;
import com.Page.HomePage;
import com.Page.LoginPage;
import com.Page.addemployeepage;
import com.Testbase.Testing;
import com.Utility.Log;

public class HomePageTest extends Testing{
	HomePage HomePage;
	LoginPage LoginPage;
	addemployeepage addemployeepage;
	Employeelistpage Employeelistpage;
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		HomePage=new HomePage();
		LoginPage= new LoginPage();
		Log.info("orange hrm launched successfully");
		Test=reports.createTest("HOme page test");	
		LoginPage.loginPagevalid(prop.getProperty("username"), prop.getProperty("password"));

		}
	@Test(priority = 1)
	public void homepagevalidatioontest() {
		Assert.assertEquals(HomePage.homepagevalidation(), "Welcome Admin", "not matched welcome page");
		Log.info("successfully opened homePage ");

	}
	@Test(priority = 2)
	public void adminPAgeTest() {
		HomePage.clickonadmin();
		Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
		
		Log.info("successfully opened  admin");

	}
	
	@Test(priority = 3)
	public void pimPageTest() {
		HomePage.clickonpim();
		Assert.assertTrue(driver.getCurrentUrl().contains("pim"));
		Log.info("successfully opened pim");

	}
	
	@Test(priority = 4)
	public void recruitementPageTest() {
		HomePage.clickonrecruitement();
		Assert.assertTrue(driver.getCurrentUrl().contains("recruitment"));
		Log.info("successfully opened recruitement");

	}
	
	@Test(priority = 5)
	public void verifyaddemployeetest() throws InterruptedException {
		addemployeepage = HomePage.clickonaddemployee();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("addEmployee"));
		Log.info("successfully opened add employee");

	}
	
	@Test(priority = 6)
	public void verifyemployeelistTest() throws InterruptedException {
		Employeelistpage = HomePage.clickonaddemployeelist();
		Assert.assertTrue(driver.getCurrentUrl().contains("viewEmployeeList"));
		Log.info("successfully opened employeelist");

	}
	
	
	@AfterTest
	public void tearDown() {
		reports.flush();
		driver.quit();
	}
	
	
	
}
