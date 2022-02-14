package org.weatherautomation.basepage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.weatherautomation.utils.ConfigLoader;

/**
 * BasePage class holds variables, instances common to all packages and class in
 * the framework Also responsible for initialization of these members Every
 * class in the framework needs to inherit the class
 * 
 * @author anand
 *
 */

public class BasePage {

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

}
