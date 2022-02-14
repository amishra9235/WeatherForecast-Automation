package org.weatherautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.weatherautomation.basepage.BasePage;

public class WeatherForecastDetailsPage extends BasePage {

	@FindBy(xpath = "//div[@class='card-header spaced-content']/h1")
	WebElement weatherTile;

	@FindBy(xpath = "//div[@class='current-weather-info']//div[@class='display-temp']")
	WebElement currentTempInCelcius;

	@FindBy(xpath = "//div[@class='current-weather-info']//div[@class='display-temp']")
	WebElement currentTempValueInCelcius;

	@FindBy(xpath = "//span[@class='cur-con-weather-card__cta']//span[text()='More Details']")
	WebElement moreDetailsBtn;

	public WeatherForecastDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public String getTempInCelcius() {

		wait.until(ExpectedConditions.elementToBeClickable(weatherTile));
		wait.until(ExpectedConditions.elementToBeClickable(currentTempInCelcius));
		return currentTempInCelcius.getText();
	}

	public void switchAndRemoveAdsFrame() {
		String url = driver.getCurrentUrl().split("#")[0];
		driver.get(url);
		moreDetailsBtn.click();

	}
}
