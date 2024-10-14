package renato.designpatterns.strategy.service.strategy;

public class IsStringEmpty implements Validation<String>{

	@Override
	public Boolean validar(String string) {
		if(string.equals(""))
			return true;
		return false;
	}

}
