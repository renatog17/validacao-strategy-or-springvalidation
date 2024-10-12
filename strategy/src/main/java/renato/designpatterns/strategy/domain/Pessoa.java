package renato.designpatterns.strategy.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import renato.designpatterns.strategy.controller.dto.CreatePessoaDTO;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataNascimento;

	public Pessoa(String nome, String cpf, String email, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Pessoa(@Valid CreatePessoaDTO createPessoaDTO) {
		this.nome = createPessoaDTO.nome();
		this.cpf = createPessoaDTO.cpf();
		this.email = createPessoaDTO.email();
		this.dataNascimento = createPessoaDTO.dataNascimento();
	}

}
