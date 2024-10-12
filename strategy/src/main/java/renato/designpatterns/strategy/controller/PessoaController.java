package renato.designpatterns.strategy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import renato.designpatterns.strategy.controller.dto.CreatePessoaDTO;
import renato.designpatterns.strategy.domain.Pessoa;
import renato.designpatterns.strategy.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@PostMapping
	public ResponseEntity<?> postPessoa(@RequestBody @Valid CreatePessoaDTO createPessoaDTO, 
		UriComponentsBuilder uriComponentsBuilder){
		
		Pessoa pessoa = new Pessoa(createPessoaDTO);
		pessoaRepository.save(pessoa);
		return ResponseEntity.ok().build();
	}
}
