package org.weatherautomation.utils;

import io.restassured.response.Response;

public class TemperaturComparator {

	public static boolean tempDiffComparator(int tempFromUI, Response res, int rangeTolerance) {
		boolean flag = false;
		double tempFromApiInKelvin = Double.parseDouble(res.jsonPath().get("main.temp").toString());
		int tempInCelciusFromApi = (int) (tempFromApiInKelvin - 273.15);
		int actualRange = tempFromUI - tempInCelciusFromApi;
		if (actualRange < rangeTolerance) {
			flag = true;
		} else {
			throw new RuntimeException("Temperature Difference is not within Specified range");
		}
		return flag;
	}

}
