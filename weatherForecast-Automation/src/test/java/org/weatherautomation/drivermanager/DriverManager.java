package org.weatherautomation.drivermanager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * DriverManager a singleton class responsible for: -- Setting Chromedriver and
 * Chrome path automatically use @WebDriverManager class -- exposes a getter for
 * chromedriver instances
 * 
 * @author anand
 *
 */
public class DriverManager {

	private static WebDriver driver = null;

	public static WebDriver getDriver(int secs) {
		if (driver == null) {
			new DriverManager(secs);
		}
		return driver;
	}

	private DriverManager(int secs) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

}
