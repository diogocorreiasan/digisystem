package br.com.digisystem.avaliacao.desafio.l.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.avaliacao.desafio.l.domain.model.Calculadora;
import br.com.digisystem.avaliacao.desafio.l.domain.model.Resultado;
import br.com.digisystem.avaliacao.desafio.l.domain.service.CalculadoraService;

@RestController
@RequestMapping(value="/calculadora")
public class CalculadoraController {
	
	private static final Logger logger = LogManager.getLogger(CalculadoraController.class);
	
	@Autowired
	private CalculadoraService calculadoraService;
	
	@PostMapping
	public ResponseEntity<?> calcular(@RequestBody Calculadora calculadora) {
		logger.info(CalculadoraController.class + " - cadastrar -" + " Dados de entrada: " + calculadora);
		
		Resultado resultado = calculadoraService.executar(calculadora);
		
		if(resultado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Informe uma Ação valida (soma, subtrai, media, total)");
		}
		
		return ResponseEntity.ok(resultado);
	}

}
