package renato.designpatterns.strategy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import renato.designpatterns.strategy.controller.dto.CreatePessoaDTO;
import renato.designpatterns.strategy.service.strategy.IsDateInThePast;
import renato.designpatterns.strategy.service.strategy.IsStringACPF;
import renato.designpatterns.strategy.service.strategy.IsStringAnEmail;
import renato.designpatterns.strategy.service.strategy.IsStringEmpty;
import renato.designpatterns.strategy.service.strategy.Validation;

@Service
public class PessoaService {

	public List<String> validar(CreatePessoaDTO createPessoaDTO){
		
		Validation isStringEmpty = new IsStringEmpty();
		Validation isDateInThePast = new IsDateInThePast();
		Validation isStringACPF = new IsStringACPF();
		Validation isStringAnEmail = new IsStringAnEmail();		
		
		List<String> erros = new ArrayList<String>();
		
		isStringEmpty.validar(createPessoaDTO.cpf());
		isStringEmpty.validar(createPessoaDTO.email());
		isStringEmpty.validar(createPessoaDTO.nome());
		
		isDateInThePast.validar(createPessoaDTO.dataNascimento());
		
		isStringACPF.validar(createPessoaDTO.cpf());
		isStringAnEmail.validar(createPessoaDTO.email());
		
		return null;
	}
}
