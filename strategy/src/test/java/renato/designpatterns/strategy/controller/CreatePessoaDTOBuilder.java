package renato.designpatterns.strategy.controller;

import java.time.LocalDate;

import renato.designpatterns.strategy.controller.dto.CreatePessoaDTO;

public class CreatePessoaDTOBuilder {

	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataNascimento;

	public CreatePessoaDTOBuilder() {
		this.nome = "Renato Default";
		this.cpf = "12345678909";
		this.email = "renato.default@example.com";
		this.dataNascimento = LocalDate.of(2000, 12, 31);
	}

	// nome
	public CreatePessoaDTOBuilder withNome(String nome) {
		this.nome = nome;
		return this;
	}

	public CreatePessoaDTOBuilder withNomeNull() {
		this.nome = null;
		return this;
	}

	public CreatePessoaDTOBuilder withNomeEmpty() {
		this.nome = "";
		return this;
	}

	// cpf
	public CreatePessoaDTOBuilder withCPF(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public CreatePessoaDTOBuilder withCPFNull() {
		this.cpf = null;
		return this;
	}
	public CreatePessoaDTOBuilder withCPFEmpty() {
		this.cpf = "";
		return this;
	}

	public CreatePessoaDTOBuilder withCPFInvalid() {
		this.cpf = "12345678910";
		return this;
	}

	// email
	public CreatePessoaDTOBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public CreatePessoaDTOBuilder withEmailNull() {
		this.email = null;
		return this;
	}

	public CreatePessoaDTOBuilder withEmailEmpty() {
		this.email = "";
		return this;
	}

	public CreatePessoaDTOBuilder withEmailInvalid() {
		this.email = "thisisntanemail";
		return this;
	}

	// data nascimento
	public CreatePessoaDTOBuilder withDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public CreatePessoaDTOBuilder withDataNascimentoNull() {
		this.dataNascimento = null;
		return this;
	}

	public CreatePessoaDTOBuilder withDataNascimentoInThePresent() {
		this.dataNascimento = LocalDate.now();
		return this;
	}

	public CreatePessoaDTOBuilder withDataNascimentoInTheFuture() {
		this.dataNascimento = LocalDate.now().plusDays(10);
		return this;
	}

	public CreatePessoaDTOBuilder withDataNascimentoInThePast() {
		this.dataNascimento = LocalDate.now().minusDays(10);
		return this;
	}
	//build
	public CreatePessoaDTO build() {
		return new CreatePessoaDTO(this.nome, this.cpf, this.email, this.dataNascimento);
	}
}
