package renato.designpatterns.strategy.service.strategy;


public class IsStringAnEmail implements Validation<String>{

	@Override
	public Boolean validar(String string) {
		if(string.contains("@") && string.contains(".com"))
			return true;
		return false;
	}

}
