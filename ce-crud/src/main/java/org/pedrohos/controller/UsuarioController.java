package org.pedrohos.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.math.BigInteger;
import java.util.Collection;

import javax.validation.Valid;

import org.pedrohos.model.dto.SaqueDTO;
import org.pedrohos.model.entities.impl.Usuario;
import org.pedrohos.model.exceptions.JaExisteException;
import org.pedrohos.model.exceptions.NaoExisteException;
import org.pedrohos.model.exceptions.SaldoInsuficienteException;
import org.pedrohos.model.repositories.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private Usuarios usuarios;
	
	@RequestMapping(value = {"/", ""}, method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public @ResponseBody Usuario criar(@Valid @RequestBody Usuario usuario) {
		
		if(usuarios.findByNomeIgnoreCase(usuario.getNome()) != null) {
			throw new JaExisteException("Usuário já Existe com nome: " + usuario.getNome());
		}
		
		return usuarios.save(usuario);
	}
	
	@RequestMapping(value = {"/", ""}, method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Usuario> todosUsuarios() {
		return usuarios.findAll();
	}
	
	@RequestMapping(value = "/saque/{nome}", method = PUT, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public @ResponseBody HttpStatus realizaSaldoSePossivel(@PathVariable String nome, @RequestBody SaqueDTO saqueDTO) {
		
		Usuario usuario = usuarios.findByNomeIgnoreCase(nome);
		
		if(usuario == null) {
			throw new NaoExisteException("Não Existe usuário com nome: " + nome);
		}
		
		BigInteger saldoAtual = usuario.getSaldo();
		
		if(saldoAtual.compareTo(saqueDTO.getValorASacar()) <= 0) {
			throw new SaldoInsuficienteException("Não Existe saldo suficiente para o usuário: " + nome + ", ou ficará com saldo Zero. Saldo: " + saldoAtual);
		}
		
		usuario.setSaldo(saldoAtual.subtract(saqueDTO.getValorASacar()));
		usuarios.save(usuario);
		
		return HttpStatus.OK; 
		
	}
	
	@RequestMapping(value = "/saldo/{nome}", method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody BigInteger pegaSaldoDoUsuario(@PathVariable String nome) {
		
		Usuario usuario = usuarios.findByNomeIgnoreCase(nome);
		
		if(usuario == null) {
			throw new NaoExisteException("Não Existe usuário com nome: " + nome);
		}
		
		return usuario.getSaldo(); 
		
	}
	
}
