package renato.designpatterns.strategy.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;


import renato.designpatterns.strategy.controller.dto.CreatePessoaDTO;
import renato.designpatterns.strategy.service.strategy.IsDateInThePast;
import renato.designpatterns.strategy.service.strategy.IsObjectNull;
import renato.designpatterns.strategy.service.strategy.IsStringACPF;
import renato.designpatterns.strategy.service.strategy.IsStringAnEmail;
import renato.designpatterns.strategy.service.strategy.IsStringEmpty;
import renato.designpatterns.strategy.service.strategy.Validation;

@Service
public class PessoaService {

	public Boolean validar(CreatePessoaDTO createPessoaDTO){
		
		Validation<String> isStringEmpty = new IsStringEmpty();
		Validation<LocalDate> isDateInThePast = new IsDateInThePast();
		Validation<String> isStringACPF = new IsStringACPF();
		Validation<String> isStringAnEmail = new IsStringAnEmail();
		Validation<Object> isObjectNull = new IsObjectNull();
		//os métodos de validação sempre vão retornar false se a validação falhar
		if(
				isStringEmpty.validar(createPessoaDTO.nome()) &&
				isObjectNull.validar((Object) createPessoaDTO.nome())&&				
				
				isStringEmpty.validar(createPessoaDTO.cpf()) &&
				isObjectNull.validar((Object) createPessoaDTO.cpf()) &&
				isStringACPF.validar(createPessoaDTO.cpf()) &&
				
				isStringEmpty.validar(createPessoaDTO.email()) &&
				isStringAnEmail.validar(createPessoaDTO.email()) &&
				isObjectNull.validar((Object) createPessoaDTO.email())&&
				
				isDateInThePast.validar(createPessoaDTO.dataNascimento()) &&
				isObjectNull.validar((Object) createPessoaDTO.dataNascimento())
		)
		return true;
		else return false;
	}
}
