package org.weatherautomation.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.weatherautomation.basepage.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath = "//img[@alt='AccuWeather Logo']")
	WebElement weatherPageLogo;

	@FindBy(xpath = "//input[@name='query']")
	WebElement weatherSearchBox;

	public HomePage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

}
 