package org.pedrohos.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.math.BigInteger;

import org.pedrohos.model.dto.SaqueDTO;
import org.pedrohos.model.exceptions.SaqueException;
import org.pedrohos.service.SaqueService;
import org.pedrohos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = {"/", ""}, method = GET, produces = APPLICATION_JSON_VALUE)
	public @ResponseBody String todosUsuarios() {
		
		SaqueDTO saqueDTO = new SaqueDTO();
		saqueDTO.setNomeCaixaEletronico("C2");
		saqueDTO.setNomeUsuario("Pedro Silva");
		saqueDTO.setValorASacar(BigInteger.TEN);
		
		try {
			usuarioService.verificaSaldoERealizaSaqueSePossivel(saqueDTO);
			
		} catch (SaqueException e) {
			throw new SaqueException(e.getMessage());
		}
		
		/*Collection<NotaDTO> notas = saqueService.realizaCalculoDeNotas(new BigInteger("130"), Arrays.asList("50", "10"));
		
		for (NotaDTO notaDTO : notas) {
			System.out.println(notaDTO.getNota() + ": " + notaDTO.getQuantidade());
		}*/
		
		return "ok";
	}

}
