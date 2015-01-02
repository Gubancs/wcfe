package hu.mortoff.wcfe.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * @author Gabor Kokeny
 *
 */
@WebService
public interface WeatherService {

	@WebMethod
	public String getWeatherForecast();

}
