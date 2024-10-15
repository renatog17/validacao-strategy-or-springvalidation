package renato.designpatterns.strategy.service.strategy;

import java.time.LocalDate;



public class IsDateInThePast implements Validation<LocalDate>{

	@Override
    public Boolean validar(LocalDate data){
        LocalDate dataAtual = LocalDate.now();
        if(data==null) {
        	return false;
        }
        if(data.isBefore(dataAtual)) {
        	return true;
        }
        return false;
    }

}
