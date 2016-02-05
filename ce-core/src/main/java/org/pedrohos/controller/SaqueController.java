package org.pedrohos.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigInteger;
import java.util.Collection;

import org.pedrohos.model.dto.NotaDTO;
import org.pedrohos.model.dto.NotasDTO;
import org.pedrohos.model.dto.SaqueDTO;
import org.pedrohos.model.exceptions.SaqueException;
import org.pedrohos.service.CaixaEletronicoService;
import org.pedrohos.service.SaqueService;
import org.pedrohos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saque")
public class SaqueController {
	
	@Autowired
	private SaqueService saqueService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CaixaEletronicoService caixaService;
	
	@RequestMapping(value = {"/", ""}, method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public @ResponseBody NotasDTO realizaSaque(@RequestBody SaqueDTO saqueDTO) {
		
		if(saqueDTO.getValorASacar().remainder(BigInteger.TEN) != BigInteger.ZERO) {
			throw new SaqueException("Aceitamos apenas saques multiplosd de 10");
		}
		
		usuarioService.verificaSaldoERealizaSaqueSePossivel(saqueDTO);
		Collection<String> notasDisponiveis = caixaService.verificaSaldoEPegaNotasDisponiveis(saqueDTO);
		Collection<NotaDTO> notas = saqueService.realizaCalculoDeNotas(saqueDTO.getValorASacar(), notasDisponiveis);
		caixaService.sacar(notas, saqueDTO.getNomeCaixaEletronico());
		
		NotasDTO notasDTO = new NotasDTO(notas);
		return notasDTO;
		
	}

}
