package br.com.digisystem.avaliacao.desafio.l.domain.available.config;

import java.math.BigDecimal;
import java.util.List;

import br.com.digisystem.avaliacao.desafio.l.domain.available.Calcular;
import br.com.digisystem.avaliacao.desafio.l.domain.model.Resultado;

public class Subtrai implements Calcular{

	@Override
	public Resultado calculo(List<Integer> numeros) {
		
		Resultado resultado = new Resultado();
		
		double valor = numeros.stream().map(n -> n.intValue()).reduce((n, i) -> n - i).orElse(0);
		resultado.setTotal(new BigDecimal(valor));
		
		return resultado;
	}

}
