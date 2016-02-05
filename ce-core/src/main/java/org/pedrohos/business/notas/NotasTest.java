package org.pedrohos.business.notas;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.pedrohos.business.notas.impl.Cem;
import org.pedrohos.business.notas.impl.Cinquenta;
import org.pedrohos.business.notas.impl.Dez;
import org.pedrohos.business.notas.impl.Vinte;
import org.pedrohos.model.dto.NotaDTO;

public class NotasTest {

	@InjectMocks
	private Cem notaCem;

	@InjectMocks
	private Cinquenta notaCinquenta;

	@InjectMocks
	private Vinte notaVinte;

	@InjectMocks
	private Dez notaDez;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testeCalculoDeNotas() {

		List<NotaDTO> notas = new ArrayList<NotaDTO>();
		NotaDTO nota = new NotaDTO();
		nota.setValorRestante(new BigInteger("490"));

		nota = notaCem.calcula(nota.getValorRestante());
		notas.add(nota);

		nota = notaCinquenta.calcula(nota.getValorRestante());
		notas.add(nota);

		nota = notaVinte.calcula(nota.getValorRestante());
		notas.add(nota);

		nota = notaDez.calcula(nota.getValorRestante());
		notas.add(nota);

		assertEquals(new BigInteger("100"), notas.get(0).getNota());
		assertEquals(new BigInteger("4"), notas.get(0).getQuantidade());
		
		assertEquals(new BigInteger("50"), notas.get(1).getNota());
		assertEquals(new BigInteger("1"), notas.get(1).getQuantidade());
		
		assertEquals(new BigInteger("20"), notas.get(2).getNota());
		assertEquals(new BigInteger("2"), notas.get(2).getQuantidade());
		
		assertEquals(new BigInteger("10"), notas.get(3).getNota());
		assertEquals(new BigInteger("0"), notas.get(3).getQuantidade());

	}

}
