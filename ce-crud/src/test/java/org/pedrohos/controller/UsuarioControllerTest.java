package org.pedrohos.controller;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.pedrohos.Application;
import org.pedrohos.model.dto.SaqueDTO;
import org.pedrohos.model.entities.impl.Usuario;
import org.pedrohos.model.repositories.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@ActiveProfiles("test")
public class UsuarioControllerTest {
	
	@Autowired
	private Usuarios usuarios;
	
	@Value("${local.server.port}")
    int port;

	private String jsonUsuario;
	private String jsonSaque;
	private Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		
		RestAssured.port = this.port;
		
		usuarios.deleteAll();
		
		usuario = new Usuario();
		usuario.setNome("Pedro Hos");
		usuario.setSaldo(new BigInteger("1000"));
	}

	@Test
	public void testeCriaUsuariosComSucesso() throws JsonProcessingException { 
		
		jsonUsuario = new ObjectMapper().writeValueAsString(usuario);
		
		given().
			contentType(ContentType.JSON).
			body(jsonUsuario).
		when().
			post("/usuario").
		then().
			statusCode(200).
			body("nome", equalTo("Pedro Hos")).
			body("saldo", equalTo(1000));
		
	}
	
	@Test
	public void testaSaqueComSucess() throws JsonProcessingException { 
		
		usuarios.save(usuario);
		
		SaqueDTO saqueDTO = new SaqueDTO();
		saqueDTO.setNomeUsuario("Pedro Hos");
		saqueDTO.setValorASacar(new BigInteger("50"));
		
		jsonSaque = new ObjectMapper().writeValueAsString(saqueDTO);
		
		given().
			contentType(ContentType.JSON).
			body(jsonSaque).
		when().
			put("/usuario/saque/Pedro Hos").
		then().
			statusCode(200);
		
		BigInteger saldo = usuarios.findByNomeIgnoreCase("Pedro Hos").getSaldo();
		
		Assert.assertEquals(new BigInteger("950"), saldo);
	}
	
	@Test
	public void testaSaqueSeSucess() throws JsonProcessingException { 
		
		usuarios.save(usuario);

		SaqueDTO saqueDTO = new SaqueDTO();
		saqueDTO.setNomeUsuario("Pedro Hos");
		saqueDTO.setValorASacar(new BigInteger("15000"));
		
		jsonSaque = new ObjectMapper().writeValueAsString(saqueDTO);
		
		given().
			contentType(ContentType.JSON).
			body(jsonSaque).
		when().
			put("/usuario/saque/Pedro Hos").
		then().
			statusCode(409).
			body(notNullValue());		
	}


}
