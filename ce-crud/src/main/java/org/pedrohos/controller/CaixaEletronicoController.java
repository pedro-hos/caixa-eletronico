package org.pedrohos.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigInteger;
import java.util.Collection;

import javax.validation.Valid;

import org.pedrohos.model.entities.impl.CaixaEletronico;
import org.pedrohos.model.exceptions.JaExisteException;
import org.pedrohos.model.exceptions.NaoExisteException;
import org.pedrohos.model.repositories.CaixasEletronico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caixa-eletronico")
public class CaixaEletronicoController {
	
	@Autowired
	private CaixasEletronico caixasEletronico;

	@RequestMapping(value = {"/", ""}, method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public @ResponseBody CaixaEletronico criar(@Valid @RequestBody CaixaEletronico caixaEletronico) {
		
		if(caixasEletronico.findByNomeIgnoreCase(caixaEletronico.getNome()) != null) {
			throw new JaExisteException("Caixa Eletrônico já Existe com nome: " + caixaEletronico.getNome());
		}
		
		return caixasEletronico.save(caixaEletronico);
	}
	
	@RequestMapping(value = {"/", ""}, method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<CaixaEletronico> todosUsuarios() {
		return caixasEletronico.findAll();
	}
	
	@RequestMapping(value = "/saldo/{nome}", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody BigInteger pegaSaldoDoUsuario(@PathVariable String nome) {
		
		CaixaEletronico caixaEletronico = caixasEletronico.findByNomeIgnoreCase(nome);
		
		if(caixaEletronico == null) {
			throw new NaoExisteException("Não Existe usuário com nome: " + nome);
		}
		
		return caixaEletronico.getSaldo(); 
		
	}
}
