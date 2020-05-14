package br.com.digisystem.avaliacao.desafio.l.domain.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.digisystem.avaliacao.desafio.l.domain.available.config.TipoCalculo;


@Component
public class CodigoService {
	
	private static final Logger logger = LogManager.getLogger(CodigoService.class);
	
	public int getCodigo(String acao) {
		logger.info(CodigoService.class + " - getCodigo");
		
		int codigo = 404;
		
		for (int i = 0; i < TipoCalculo.values().length; i++) {
			if(TipoCalculo.values()[i].getDescricao().equals(acao.toLowerCase())) {
				codigo = i;
			}
		}
		
		return codigo;
	}

}
