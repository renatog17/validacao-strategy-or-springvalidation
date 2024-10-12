package renato.designpatterns.strategy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import renato.designpatterns.strategy.controller.dto.CreatePessoaDTO;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PessoaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testPostPessoa() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().build();
		System.out.println(createPessoaDTO.toString());
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	// Name
	@Test
	public void testPostPessoaWithEmptyName() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withNomeEmpty().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testPostPessoaWithNullName() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withNomeNull().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	// CPF
	@Test
	public void testPostPessoaWithEmptyCPF() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withCPFEmpty().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testPostPessoaWithNullCPF() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withCPFNull().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testPostPessoaWithInvalidCPF() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withCPFInvalid().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	// Email
	@Test
	public void testPostPessoaWithEmptyEmail() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withEmailEmpty().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testPostPessoaWithNullEmail() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withEmailNull().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testPostPessoaWithInvalidEmail() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withEmailEmpty().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	// DataNascimento
	@Test
	public void testPostPessoaWithNullDataNascimento() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withDataNascimentoNull().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testPostPessoaWithFutureDataNascimento() throws JsonProcessingException, Exception {
		// arrange
		CreatePessoaDTO createPessoaDTO = new CreatePessoaDTOBuilder().withDataNascimentoInTheFuture().build();
		// act & assert
		mockMvc.perform(MockMvcRequestBuilders.post("/pessoas").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createPessoaDTO)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
