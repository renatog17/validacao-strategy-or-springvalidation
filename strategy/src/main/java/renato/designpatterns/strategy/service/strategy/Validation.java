package renato.designpatterns.strategy.service.strategy;


public interface Validation<T> {

	Boolean validar(T input);
}
