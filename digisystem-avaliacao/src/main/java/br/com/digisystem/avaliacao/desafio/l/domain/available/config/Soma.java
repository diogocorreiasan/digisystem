package br.com.digisystem.avaliacao.desafio.l.domain.available.config;

import java.util.List;

import br.com.digisystem.avaliacao.desafio.l.domain.available.Calcular;
import br.com.digisystem.avaliacao.desafio.l.domain.model.Resultado;

public class Soma implements Calcular{

	@Override
	public Resultado calculo(List<Integer> numeros) {
		
		Resultado resultado = new Resultado();
		
		double valor = numeros.stream().map(n -> n.intValue()).reduce((n, i) -> n + i).orElse(0);
		resultado.setTotal(valor);
		
		return resultado;
	}

}
