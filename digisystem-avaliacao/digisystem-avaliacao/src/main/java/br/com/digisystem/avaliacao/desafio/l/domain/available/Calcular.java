package br.com.digisystem.avaliacao.desafio.l.domain.available;

import java.util.List;

import br.com.digisystem.avaliacao.desafio.l.domain.model.Resultado;

public interface Calcular {

	public Resultado calculo(List<Integer> numeros);
	
}
