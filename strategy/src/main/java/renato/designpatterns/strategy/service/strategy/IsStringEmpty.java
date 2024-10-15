package renato.designpatterns.strategy.service.strategy;

public class IsStringEmpty implements Validation<String>{

	@Override
	public Boolean validar(String string) {
		if(string==null) return false;
		if(string.equals(""))
			return false;
		return true;
	}

}
