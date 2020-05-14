package br.com.digisystem.avaliacao.desafio.ll.controller;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.avaliacao.desafio.ll.domain.exception.NegocioException;
import br.com.digisystem.avaliacao.desafio.ll.domain.model.Pessoa;
import br.com.digisystem.avaliacao.desafio.ll.domain.service.PessoaService;

@RestController
@RequestMapping(value="/pessoa")
public class PessoaController {
	
	private static final Logger logger = LogManager.getLogger(PessoaController.class);
	
	@Autowired
	private PessoaService pessoaService;

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Pessoa pessoa){
		logger.info(PessoaService.class + " - cadastrar -" + " Dados de entrada:" + pessoa);
		
		Pessoa retorno = pessoaService.salvar(pessoa);
		logger.info(PessoaService.class + " Pessoa cadastrada: "+ retorno);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(retorno);
	}
	
	@GetMapping
	public ResponseEntity<?> buscar(){
		logger.info(PessoaService.class + " - Metodo - buscar");
		
		List<Pessoa> pessoas = pessoaService.buscarTodos();
		logger.info(PessoaService.class + " - Busca realizada: "+ pessoas);
		
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		logger.info(PessoaService.class + " - buscarPorId -" + " Dados de entrada:" + id);
		
		Pessoa pessoa = pessoaService.buscarPorId(id)
				.orElseThrow(() -> new NegocioException(String.format("Não existe um cadastro de uma pessoa com código %d", id)));
		logger.info(PessoaService.class + " - Busca realizada: " + pessoa);
		
		return ResponseEntity.ok(pessoa);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> buscarPorNome(@PathVariable String nome){
		logger.info(PessoaService.class + " - buscarPorNome - "+ " Dados de entrada: " + nome);
		
		List<Pessoa> pessoas = pessoaService.buscarPorNome(nome);
		logger.info(PessoaService.class + " - Busca realizada: " + pessoas);
		
		return ResponseEntity.ok(pessoas);
	}
	
	@GetMapping("/salario/{salario}")
	public ResponseEntity<?> buscarPorSalario(@PathVariable BigDecimal salario){
		logger.info(PessoaService.class + " - buscarPorSalario - " + " Dados de entrada: " + salario);
		
		List<Pessoa> pessoas = pessoaService.buscarPorSalario(salario);
		logger.info(PessoaService.class + " - Busca realizada: " + pessoas);
		
		return ResponseEntity.ok(pessoas);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable Long id, 
			@RequestBody Pessoa pessoa){
		logger.info(PessoaService.class + " - alterar - " + " Dados de entrada: " + id + " - Pessoa: " + pessoa);
		
		Pessoa pessoaAtual = pessoaService.buscarOuFalhar(id);
		logger.info(PessoaService.class + " - Busca realizada: " + pessoaAtual);
		
		BeanUtils.copyProperties(pessoa, pessoaAtual, "id");
		
		Pessoa retorno = pessoaService.salvar(pessoaAtual);
		logger.info(PessoaService.class + " - Pessoa alterada: " + retorno);
		
		return ResponseEntity.ok(retorno);
	}
}