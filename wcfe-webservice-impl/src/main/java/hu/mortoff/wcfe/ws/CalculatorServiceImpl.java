package hu.mortoff.wcfe.ws;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Gabor Kokeny
 *
 */
@Component
@WebService(serviceName = "calculatorService")
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public int sum(int... a) {
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		return sum;
	}

	@Override
	public double pow(double a, double b) {
		return Math.pow(a, b);
	}

	@Override
	public int min(int a, int b) {
		return Math.min(a, b);
	}

	@Override
	public int max(int a, int b) {
		return Math.max(a, b);
	}

}
