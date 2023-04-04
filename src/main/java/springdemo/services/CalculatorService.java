package springdemo.services;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

	public Integer calculate(Integer num1, Integer num2, String mode) {

		if ("add".equals(mode)){
			return num1 + num2;
		}
		else if ("subtract".equals(mode)) {
			return num1 - num2;
		}
		else if ("multiply".equals(mode)) {
			return num1*num2;
		}
		else if ("divide".equals(mode)) {
			return num1/num2;
		}
		else if("power".equals(mode)) {
			if (null == num2) {
				return num1*num1;
			}
			else {
				return (int) Math.pow(num1.intValue(), num2.intValue());
			}
		}
		throw new IllegalArgumentException("Illegal operation mode!");
		
	}

}
