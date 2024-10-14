package renato.designpatterns.strategy.service.strategy;

import java.time.LocalDate;

public class IsDateInThePast implements Validation<LocalDate>{

	@Override
    public Boolean validar(LocalDate data) {
        LocalDate dataAtual = LocalDate.now();
        return data.isBefore(dataAtual);
    }

}
