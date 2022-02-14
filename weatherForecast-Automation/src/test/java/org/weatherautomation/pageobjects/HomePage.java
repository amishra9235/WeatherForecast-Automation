package org.weatherautomation.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.weatherautomation.basepage.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = "//img[@alt='AccuWeather Logo']")
	WebElement weatherPageLogo;

	@FindBy(xpath = "//input[@name='query']")
	WebElement weatherSearchBox;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		BasePage.driver.switchTo().alert().accept();
	}

	public void enterCityName(String cityName) {
		//acceptAlert();
		wait.until(ExpectedConditions.elementToBeClickable(weatherPageLogo));
		wait.until(ExpectedConditions.elementToBeClickable(weatherSearchBox));
		weatherSearchBox.click();
		weatherSearchBox.sendKeys(cityName);
		weatherSearchBox.sendKeys(Keys.ENTER);

	}

}
