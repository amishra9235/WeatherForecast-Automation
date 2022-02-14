package org.weatherautomation.drivermanager;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

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
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();

		// SET CHROME OPTIONS
		// 0 - Default, 1 - Allow, 2 - Block
		contentSettings.put("geolocation", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		// SET CAPABILITY
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

}
