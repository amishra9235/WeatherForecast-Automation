package org.weatherautomation.utils;

import java.util.Properties;

import org.weatherautomation.constants.EnvType;

public class ConfigLoader {
	private final Properties properties;
	private static ConfigLoader configLoader;

	private ConfigLoader() {
		properties = PropertyUtils.propertyLoader();

	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getApiBaseUrl() {
		String prop = properties.getProperty("ApiBaseUrl");
		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property apiBaseUrl is not specified in the stg_config.properties file");
	}

	public String getUiUrl() {
		String prop = properties.getProperty("UIBaseUrl");
		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property UIBaseUrl is not specified in the stg_config.properties file");
	}

	public String getApiKey() {
		String prop = properties.getProperty("ApiKey");
		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property ApiKey is not specified in the stg_config.properties file");
	}

	public String getCityName() {
		String prop = properties.getProperty("cityName");
		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property CityName is not specified in the stg_config.properties file");
	}

	public String getWaitTimeInSecs() {
		String prop = properties.getProperty("wait");
		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property webdriverWait is not specified in the stg_config.properties file");
	}

}
