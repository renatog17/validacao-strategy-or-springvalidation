package renato.designpatterns.strategy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PessoaControllerTest {

	@Test
	public void testPostPessoa() {
		
	}
	//Name
	@Test
	public void testPostPessoaWithEmptyName() {
		
	}
	
	@Test
	public void testPostPessoaWithNullName() {
		
	}
	//CPF
	@Test
	public void testPostPessoaWithEmptyCPF() {
		
	}
	@Test
	public void testPostPessoaWithNullCPF() {
		
	}
	@Test
	public void testPostPessoaWithInvalidCPF() {
		
	}
	//Email
	@Test
	public void testPostPessoaWithEmptyEmail() {
		
	}
	@Test
	public void testPostPessoaWithNullEmail() {
		
	}
	@Test
	public void testPostPessoaWithInvalidEmail() {
		
	}
	//DataNascimento
	@Test
	public void testPostPessoaWithNullDataNascimento() {
		
	}
	@Test
	public void testPostPessoaWithFutureDataNascimento() {
		
	}
	
}
