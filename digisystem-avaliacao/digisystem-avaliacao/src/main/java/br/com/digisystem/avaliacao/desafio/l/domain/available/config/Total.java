package br.com.digisystem.avaliacao.desafio.l.domain.available.config;

import java.math.BigDecimal;
import java.util.List;

import br.com.digisystem.avaliacao.desafio.l.domain.available.Calcular;
import br.com.digisystem.avaliacao.desafio.l.domain.model.Resultado;

public class Total implements Calcular{

	@Override
	public Resultado calculo(List<Integer> numeros) {
		Resultado resultado = new Resultado();
		
		resultado.setTotal(new BigDecimal(numeros.size()));
		
		return resultado;
	}

}
