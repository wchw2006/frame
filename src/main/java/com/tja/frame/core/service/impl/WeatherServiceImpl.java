package com.tja.frame.core.service.impl;

import gen.wsdl.Forecast;
import gen.wsdl.ForecastReturn;
import gen.wsdl.GetCityForecastByZIP;
import gen.wsdl.GetCityForecastByZIPResponse;
import gen.wsdl.Temp;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.tja.frame.core.service.WeatherService;

@Service
public class WeatherServiceImpl  implements
		WeatherService {

	@Autowired
    private WebServiceTemplate webServiceTemplate;
	
	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {
		GetCityForecastByZIP request = new GetCityForecastByZIP();
		request.setZIP(zipCode);

		System.out.println();
		System.out.println("Requesting forecast for " + zipCode);

		String uri = "http://wsf.cdyne.com/WeatherWS/Weather.asmx";
		GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) webServiceTemplate.marshalSendAndReceive(
				uri,
				request,
				new SoapActionCallback(
						"http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));

		return response;
	}

	public void printResponse(GetCityForecastByZIPResponse response) {
		ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();

		if (forecastReturn.isSuccess()) {
			System.out.println();
			System.out.println("Forecast for " + forecastReturn.getCity() + ", "
					+ forecastReturn.getState());

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {
				System.out.print(format.format(forecast.getDate().toGregorianCalendar().getTime()));
				System.out.print(" ");
				System.out.print(forecast.getDesciption());
				System.out.print(" ");
				Temp temperature = forecast.getTemperatures();
				System.out.print(temperature.getMorningLow() + "\u00b0-"
						+ temperature.getDaytimeHigh() + "\u00b0 ");
				System.out.println();
			}
		} else {
			System.out.println("No forecast received");
		}
	}

	
}
