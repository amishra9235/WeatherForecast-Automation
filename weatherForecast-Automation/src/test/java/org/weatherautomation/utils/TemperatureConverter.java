package org.weatherautomation.utils;

public class TemperatureConverter {

	public static int getTempInCencius(double tempInKelvin) {
		int Celsius = (int) (tempInKelvin - 273.15);
		return Celsius;
	}

}
