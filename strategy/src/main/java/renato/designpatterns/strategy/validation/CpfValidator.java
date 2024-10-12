package renato.designpatterns.strategy.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<ValidCpf, String> {

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		return isCpfValid(cpf);
	}

	private boolean isCpfValid(String cpf) {
		if (cpf == null || cpf.trim().isEmpty()) {
	        return false; // Invalid format: cpf cannot be null or empty
	    }

		cpf = cpf.replaceAll("\\D", "");

		if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
			return false; // Invalid format
		}

		if (cpf.matches("(\\d)\\1{10}")) {
			return false;
		}
		return validateCheckDigits(cpf);
	}

	private boolean validateCheckDigits(String cpf) {
		int firstCheckDigit = calculateCheckDigit(cpf.substring(0, 9));
		int secondCheckDigit = calculateCheckDigit(cpf.substring(0, 9) + firstCheckDigit);
		return cpf.charAt(9) == (char) ('0' + firstCheckDigit) && cpf.charAt(10) == (char) ('0' + secondCheckDigit);
	}

	private int calculateCheckDigit(String base) {
		int sum = 0;
		int weight = base.length() + 1;

		for (char digit : base.toCharArray()) {
			sum += (digit - '0') * weight--;
		}

		int remainder = sum % 11;
		return (remainder < 2) ? 0 : (11 - remainder);
	}

}
