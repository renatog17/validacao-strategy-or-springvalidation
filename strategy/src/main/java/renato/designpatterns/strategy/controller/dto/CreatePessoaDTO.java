package renato.designpatterns.strategy.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import renato.designpatterns.strategy.validation.ValidCpf;

public record CreatePessoaDTO(
		@NotNull(message = "Campo 'nome' não pode estar vazio ou nulo")
		String nome,
		@ValidCpf
		@NotNull(message = "Campo 'cpf' não pode estar vazio ou nulo")
		String cpf,
		@Email
		@NotNull(message = "Campo 'email' não pode estar vazio ou nulo")
		String email,
		@Past
		@NotNull(message = "Campo 'dataNascimento' não pode estar vazio ou nulo")
		String dataNascimento) {

}
