package hu.mortoff.wcfe.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CalculatorService {

	@WebMethod
	public int sum(int... a);

	@WebMethod
	public int min(int a, int b);

	@WebMethod
	public int max(int a, int b);

	@WebMethod
	public double pow(double a, double b);
}
