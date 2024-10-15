package renato.designpatterns.strategy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import renato.designpatterns.strategy.controller.dto.CreatePessoaDTO;
import renato.designpatterns.strategy.domain.Pessoa;
import renato.designpatterns.strategy.repository.PessoaRepository;
import renato.designpatterns.strategy.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	private final PessoaRepository pessoaRepository;
	private final PessoaService pessoaService;
	
	public PessoaController(PessoaRepository pessoaRepository, PessoaService pessoaService) {
		this.pessoaRepository = pessoaRepository;
		this.pessoaService = pessoaService;
	}
	
	
	@PostMapping
	public ResponseEntity<?> postPessoa(@RequestBody CreatePessoaDTO createPessoaDTO, 
		UriComponentsBuilder uriComponentsBuilder) throws MethodArgumentNotValidException{
		
		if(!pessoaService.validar(createPessoaDTO)) return ResponseEntity.badRequest().build();
		
		Pessoa pessoa = new Pessoa(createPessoaDTO);
		pessoaRepository.save(pessoa);
		return ResponseEntity.created(null).build();
	}
}
