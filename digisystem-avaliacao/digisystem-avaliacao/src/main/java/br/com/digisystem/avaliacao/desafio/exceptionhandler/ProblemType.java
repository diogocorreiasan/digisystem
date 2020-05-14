package br.com.digisystem.avaliacao.desafio.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	ENTIDADE_NAO_ENCONTRADA("Entidade não encontrada"),
	ERRO_NEGOCIO("Violação de regra de negócio");
	
	private String title;
	
	ProblemType( String title) {
		this.title = title;
	}
	
}
