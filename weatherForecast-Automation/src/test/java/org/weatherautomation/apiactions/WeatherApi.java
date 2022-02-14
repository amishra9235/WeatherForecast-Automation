package org.weatherautomation.apiactions;

import io.restassured.response.Response;

import java.util.HashMap;

import org.weatherautomation.utils.ConfigLoader;

import static io.restassured.RestAssured.given;

public class WeatherApi {

	public WeatherApi() {
	}

	public Response getWeatherForecast() {
		HashMap<String, Object> formParams = new HashMap<String, Object>();
		formParams.put("q", ConfigLoader.getInstance().getCityName());
		formParams.put("appid", ConfigLoader.getInstance().getApiKey());
		Response response = given().baseUri(ConfigLoader.getInstance().getApiBaseUrl()).formParams(formParams).log()
				.all().when().get("/weather").then().log().all().extract().response();
		if (response.getStatusCode() != 200) {
			throw new RuntimeException("Failed to get City Forecats" + ConfigLoader.getInstance().getCityName()
					+ ", HTTP Status Code: " + response.getStatusCode());
		}
		return response;
	}
}
