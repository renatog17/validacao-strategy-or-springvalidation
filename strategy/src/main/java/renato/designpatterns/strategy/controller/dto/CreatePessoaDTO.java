package renato.designpatterns.strategy.controller.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import renato.designpatterns.strategy.validation.ValidCpf;

public record CreatePessoaDTO(
		@NotBlank(message = "Campo 'nome' não pode estar vazio ou nulo")
		String nome,
		@ValidCpf
		@NotBlank(message = "Campo 'cpf' não pode estar vazio ou nulo")
		@NotNull
		String cpf,
		@Email
		@NotBlank(message = "Campo 'email' não pode estar vazio ou nulo")
		String email,
		@Past
		@NotNull(message = "Campo 'dataNascimento' não pode estar vazio ou nulo")
		LocalDate dataNascimento) {

}
