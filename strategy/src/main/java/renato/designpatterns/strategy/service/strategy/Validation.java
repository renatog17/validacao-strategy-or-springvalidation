package renato.designpatterns.strategy.service.strategy;

import org.springframework.web.bind.MethodArgumentNotValidException;

public interface Validation<T> {

	//@return this method should return true if the validation is ok 
	Boolean validar(T input);
}
