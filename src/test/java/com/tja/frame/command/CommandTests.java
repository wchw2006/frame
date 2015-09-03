package com.tja.frame.command;

import gen.wsdl.GetCityForecastByZIPResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tja.frame.core.service.WeatherService;
import com.tja.frame.mobile.support.Command;
import com.tja.frame.mobile.support.CommandProvider;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"/context-*.xml",
	"/core-context-*.xml"
})
public class CommandTests {

	@Autowired
	CommandProvider commandProvider;
	
	@Autowired 
	WeatherService weatherService;
	
	@Test
	public void testInject() {
		Command  command = commandProvider.findCommandByKey("01");
		Assert.assertNotNull(command);
		Assert.assertEquals("userServiceImpl", command.getClazz());
		
		Command  command2 = commandProvider.findCommandByKey("03");
		Assert.assertNotNull(command2);
		Assert.assertEquals("organizationServiceImpl", command2.getClazz());
	}
	
	@Test
	public void testWeather() {
		GetCityForecastByZIPResponse response = weatherService.getCityForecastByZip("94304");
		weatherService.printResponse(response);
	}
}
