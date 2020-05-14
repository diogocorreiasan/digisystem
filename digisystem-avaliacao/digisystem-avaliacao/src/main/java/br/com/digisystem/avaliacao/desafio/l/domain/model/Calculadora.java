package br.com.digisystem.avaliacao.desafio.l.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class Calculadora {
	
	private String acao;
	private List<Integer> numeros;

}
