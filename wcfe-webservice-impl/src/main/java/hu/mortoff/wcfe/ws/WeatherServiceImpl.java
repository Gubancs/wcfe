package hu.mortoff.wcfe.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

@Component
@WebService(serviceName = "weatherService")
public class WeatherServiceImpl implements WeatherService {

	@WebMethod
	public String getWeatherForecast() {

		return "Hurray !!! Today's weather will be SUNNY with temperature around 21 degree Celcius";
	}

}
