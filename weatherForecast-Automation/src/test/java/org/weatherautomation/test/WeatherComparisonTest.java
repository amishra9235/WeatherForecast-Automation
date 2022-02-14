package org.weatherautomation.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.weatherautomation.apiactions.WeatherApi;
import org.weatherautomation.basepage.BasePage;
import org.weatherautomation.drivermanager.DriverManager;
import org.weatherautomation.pageobjects.HomePage;
import org.weatherautomation.pageobjects.WeatherForecastDetailsPage;
import org.weatherautomation.pageobjects.WeatherForecastPage;
import org.weatherautomation.utils.ConfigLoader;
import org.weatherautomation.utils.TemperatureConverter;

import io.restassured.response.Response;

public class WeatherComparisonTest {

	HomePage homePage;
	WeatherForecastPage foreCastPage;
	WeatherForecastDetailsPage foreCastDetailPage;

	@BeforeMethod
	public void initTest() {
		new BasePage(DriverManager.getDriver(10));
		BasePage.driver.get(ConfigLoader.getInstance().getUiUrl());
		homePage = new HomePage(BasePage.driver);
		homePage.enterCityName(ConfigLoader.getInstance().getCityName());
		foreCastPage = new WeatherForecastPage(BasePage.driver);
		foreCastPage.ClickMoreDetailsBtn();
		foreCastDetailPage = new WeatherForecastDetailsPage(BasePage.driver);

	}

	@Test
	public void validateHomePage() {
		boolean flag = false;
		Response res = new WeatherApi().getWeatherForecast();
		foreCastDetailPage.switchAndRemoveAdsFrame();
		String temp = foreCastDetailPage.getTempInCelcius();
		String arr[] = temp.split("°C");
		int tempInCelciusFromUI = Integer.parseInt(arr[0]);
		double tempFromApiInKelvin = Double.parseDouble(res.jsonPath().get("main.temp").toString());
		int tempInCelciusFromApi = TemperatureConverter.getTempInCencius(tempFromApiInKelvin);
		if ((tempInCelciusFromUI - tempInCelciusFromApi) < 3) {
			flag = true;
		}
		assertEquals(true, flag, "The Temperature difference is not between specified range");

	}

	@AfterMethod
	public void tearTest() {
		if (BasePage.driver != null) {
			BasePage.driver.quit();
		}

	}

}
