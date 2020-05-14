package br.com.digisystem.avaliacao.desafio.ll.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.avaliacao.desafio.ll.domain.exception.PessoaNaoEncontradaException;
import br.com.digisystem.avaliacao.desafio.ll.domain.model.Pessoa;
import br.com.digisystem.avaliacao.desafio.ll.domain.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private static final Logger logger = LogManager.getLogger(PessoaService.class);
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvar(Pessoa pessoa) {
		logger.info(PessoaService.class + "Servico - Salvar");
		return pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> buscarTodos(){
		logger.info(PessoaService.class + " - Servico - Buscar Todos");
		return pessoaRepository.findAll();
	}
	
	public List<Pessoa> buscarPorNome(String nome) {
		logger.info(PessoaService.class + " - Servico - Buscar por nome");
		return pessoaRepository.consultarPorNome(nome);
	}
	
	public Optional<Pessoa> buscarPorId(Long id) {
		logger.info(PessoaService.class + " - Servico - Buscar por id");
		return pessoaRepository.findById(id);
	}
	
	public List<Pessoa> buscarPorSalario(BigDecimal salario) {
		logger.info(PessoaService.class + " - Servico - Buscar por salario");
		return pessoaRepository.consultarPorSalario(salario);
	}
	
	public Pessoa buscarOuFalhar(Long id) {
		logger.info(PessoaService.class + " - Servico - Buscar ou falhar");
		return pessoaRepository.findById(id)
			.orElseThrow(() -> new PessoaNaoEncontradaException(id));
	}

}
