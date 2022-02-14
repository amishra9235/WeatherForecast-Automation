package org.weatherautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.weatherautomation.basepage.BasePage;

public class WeatherForecastPage extends BasePage {

	@FindBy(xpath = "//h2[@class='cur-con-weather-card__title']")
	WebElement currentWeatherTile;

	@FindBy(xpath = "//span[@class='cur-con-weather-card__cta']//span[text()='More Details']")
	WebElement moreDetailsBtn;

	public WeatherForecastPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void ClickMoreDetailsBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(currentWeatherTile));
		wait.until(ExpectedConditions.elementToBeClickable(moreDetailsBtn));
		moreDetailsBtn.click();
	}

}
