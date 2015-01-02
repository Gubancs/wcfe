package hu.mortoff.wcfe.clients;

import hu.mortoff.wcfe.ws.CalculatorService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculatorConsumerClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"weatherConsumer.xml");

		CalculatorService calc = applicationContext.getBean(
				"calculatorService", CalculatorService.class);

		System.out.println("4+9=" + calc.sum(4, 9));
		System.out.println("4+9+12=" + calc.sum(4, 9, 12));
		System.out.println("4+9+12+3=" + calc.sum(4, 9, 12, 3));
		System.out.println("min(53,22)=" + calc.min(53, 22));
		System.out.println("max(53,22)=" + calc.max(53, 22));
		System.out.println("pow(7,2)=" + calc.pow(7, 2));

		applicationContext.close();
	}
}
