package org.weatherautomation.utils;

import java.util.Properties;

import org.weatherautomation.constants.EnvType;

public class ConfigLoader {
	private final Properties properties;
	private static ConfigLoader configLoader;

	private ConfigLoader() {
		String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
		switch (EnvType.valueOf(env)) {

		case STAGE:
			properties = PropertyUtils.propertyLoader("src/test/resources/stg_config.properties");
			break;

		case PRODUCTION:
			properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
			break;
		default:
			throw new IllegalStateException("Invalid env type: " + env);
		}
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getApiBaseUrl() {
		String prop = properties.getProperty("apiBaseUrl");
		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property apiBaseUrl is not specified in the stg_config.properties file");
	}

	public String getUiUrl() {
		String prop = properties.getProperty("uiBaseUrl");
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
