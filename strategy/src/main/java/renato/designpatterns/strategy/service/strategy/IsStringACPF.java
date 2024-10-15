package renato.designpatterns.strategy.service.strategy;



public class IsStringACPF implements Validation<String>{
	@Override
    public Boolean validar(String cpf) {
		if(cpf==null) {
			return false;
		}
        cpf = cpf.replaceAll("[^\\d]", "");
        if (cpf.length() != 11) {
        	return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
        	return false;
        }
        return isValidCPF(cpf);
    }

    // Método auxiliar para validar o CPF usando a regra dos dígitos verificadores
    private boolean isValidCPF(String cpf) {
        try {
            int sum = 0;
            int weight = 10;

            // Calcula o primeiro dígito verificador
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * weight--;
            }

            int firstVerifierDigit = 11 - (sum % 11);
            if (firstVerifierDigit >= 10) {
                firstVerifierDigit = 0;
            }

            // Verifica o primeiro dígito
            if (firstVerifierDigit != (cpf.charAt(9) - '0')) {
                return false;
            }

            // Calcula o segundo dígito verificador
            sum = 0;
            weight = 11;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * weight--;
            }

            int secondVerifierDigit = 11 - (sum % 11);
            if (secondVerifierDigit >= 10) {
                secondVerifierDigit = 0;
            }

            // Verifica o segundo dígito
            return secondVerifierDigit == (cpf.charAt(10) - '0');
        } catch (Exception e) {
            return false; // Caso haja alguma exceção, retorna falso
        }
    }
}