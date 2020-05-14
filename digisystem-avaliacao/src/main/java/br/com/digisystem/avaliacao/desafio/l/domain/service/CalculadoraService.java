package br.com.digisystem.avaliacao.desafio.l.domain.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.avaliacao.desafio.l.controller.CalculadoraController;
import br.com.digisystem.avaliacao.desafio.l.domain.available.Calcular;
import br.com.digisystem.avaliacao.desafio.l.domain.available.config.TipoCalculo;
import br.com.digisystem.avaliacao.desafio.l.domain.model.Calculadora;
import br.com.digisystem.avaliacao.desafio.l.domain.model.Resultado;

@Service
public class CalculadoraService {
	
	private static final Logger logger = LogManager.getLogger(CalculadoraController.class);
	
	@Autowired
	private CodigoService codigoService;
	
	public Resultado executar(Calculadora calculadora) {
		logger.info(CalculadoraController.class + " - Servico - executar");
		
		int codigo = codigoService.getCodigo(calculadora.getAcao());
		logger.info(CalculadoraController.class + " -Retorno do servico: " + codigo);
		
		if(codigo == 404) {
			return null;
		}
		
		TipoCalculo tipoCalculo = TipoCalculo.values()[codigo];
		Calcular calcular = tipoCalculo.oberTipoCalculo();
		
		Resultado resultado = calcular.calculo(calculadora.getNumeros());
		logger.info(CalculadoraController.class + " - Resultado: " + resultado);
		
		return resultado;
	}

}
