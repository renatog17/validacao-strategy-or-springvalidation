package renato.designpatterns.strategy.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CpfValidator implements ConstraintValidator<ValidCpf, String> {

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        // Implement CPF validation logic here
        return isCpfValid(cpf);
    }

    private boolean isCpfValid(String cpf) {
        // CPF validation logic, for example:
        // 1. Remove non-numeric characters
        // 2. Check length
        // 3. Validate check digits

        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            return false; // Invalid format
        }

        // Implement your own CPF validation logic (check digits, etc.)
        return true; // Return true if valid, false otherwise
    }
}
