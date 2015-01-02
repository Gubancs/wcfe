package hu.mortoff.wcfe.clients;

import hu.mortoff.wcfe.ws.WeatherService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WeatherServiceConsumerClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"weatherConsumer.xml");
		WeatherService weatherService = (WeatherService) applicationContext
				.getBean("weatherService");

		System.out.println(weatherService.getWeatherForecast());

		applicationContext.close();
	}

}
