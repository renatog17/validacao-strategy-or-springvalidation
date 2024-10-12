package renato.designpatterns.strategy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import renato.designpatterns.strategy.controller.dto.CreatePessoaDTO;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@PostMapping
	public ResponseEntity<?> postPessoa(@RequestBody CreatePessoaDTO createPessoaDTO){
		
		return ResponseEntity.ok().build();
	}
}
