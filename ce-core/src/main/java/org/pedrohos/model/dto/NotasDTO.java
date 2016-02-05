package org.pedrohos.model.dto;

import java.util.Collection;

public class NotasDTO {
	
	private String notas;

	public NotasDTO() { }
	
	public NotasDTO(Collection<NotaDTO> notas) {
		StringBuilder notasBuilder = new StringBuilder();
		
		notas.forEach(n -> {
			
			notasBuilder.append("Nota: ");
			notasBuilder.append(n.getNota());
			notasBuilder.append(" ");
			
			notasBuilder.append("Quantidade: ");			
			notasBuilder.append(n.getQuantidade());
			notasBuilder.append("; ");
			
		});
		
		this.notas = notasBuilder.toString();
	
	}


	public String getNotas() {
		return notas;
	}
	
}
