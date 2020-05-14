package br.com.digisystem.avaliacao.desafio.l.domain.available.config;

import java.util.List;

import br.com.digisystem.avaliacao.desafio.l.domain.available.Calcular;
import br.com.digisystem.avaliacao.desafio.l.domain.model.Resultado;

public class Media implements Calcular{

	@Override
	public Resultado calculo(List<Integer> numeros) {
		Resultado resultado = new Resultado();
		
		double soma = numeros.stream().map(n -> n.intValue()).reduce((n, i) -> n + i).orElse(0);
		resultado.setTotal(soma / (double)numeros.size());
		
		return resultado;
	}

}
