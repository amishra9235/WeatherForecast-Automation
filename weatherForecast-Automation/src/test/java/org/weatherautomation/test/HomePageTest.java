package org.weatherautomation.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.weatherautomation.drivermanager.DriverManager;

public class HomePageTest extends BaseTest {

	@BeforeMethod
	public void initTest() {
		driver = DriverManager.getDriver();
		driver.manage().window().maximize();
		driver.get("https://www.accuweather.com/");

	}

	@Test
	public void validateHomePage() {
		assertEquals(driver.getTitle(), "Local, National, & Global Daily Weather Forecast | AccuWeather");

	}

	@AfterMethod
	public void tearTest() {
		if (driver != null) {
			driver.quit();
		}

	}
}
