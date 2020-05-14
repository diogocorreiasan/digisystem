package br.com.digisystem.avaliacao.desafio.l.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Resultado {

	private BigDecimal total;
	
	public static void main(String[] args) {
		 Double a = 100D, b = 3D;
	        System.out.println( String.format("%.2f", a/b) );
	}
	
}
