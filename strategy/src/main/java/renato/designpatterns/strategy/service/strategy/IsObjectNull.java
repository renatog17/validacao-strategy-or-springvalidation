package renato.designpatterns.strategy.service.strategy;

public class IsObjectNull implements Validation<Object>{

	@Override
	public Boolean validar(Object input) {
		if(input == null) return false;
		return true;
	}

}
