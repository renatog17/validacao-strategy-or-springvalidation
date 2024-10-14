package renato.designpatterns.strategy.controller.dto;

import java.time.LocalDate;

public record CreatePessoaDTO(
		String nome,
		String cpf,
		String email,
		LocalDate dataNascimento) {

}
