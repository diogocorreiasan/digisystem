package br.com.digisystem.avaliacao.desafio.ll.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digisystem.avaliacao.desafio.ll.domain.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> consultarPorNome(String nome);

	List<Pessoa> consultarPorSalario(BigDecimal salario);

}
