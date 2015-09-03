package com.tja.frame.core.service;

import gen.wsdl.GetCityForecastByZIPResponse;

public interface WeatherService {

	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode);
	
	public void printResponse(GetCityForecastByZIPResponse response);
	
	
}
