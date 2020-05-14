package br.com.digisystem.avaliacao.desafio.l.domain.available.config;

import br.com.digisystem.avaliacao.desafio.l.domain.available.Calcular;
import lombok.Getter;

@Getter
public enum TipoCalculo {

	SOMA("soma") {
		@Override
		public Calcular oberTipoCalculo() {
			return new Soma();
		}
	},
	SUBTRAI("subtrai") {
		@Override
		public Calcular oberTipoCalculo() {
			return new Subtrai();
		}
	},
	MEDIA("media") {
		@Override
		public Calcular oberTipoCalculo() {
			return new Media();
		}
	},
	TOTAL("total") {
		@Override
		public Calcular oberTipoCalculo() {
			return new Total();
		}
	};
	
	private String descricao;
	
	private TipoCalculo(String descricao) {
		this.descricao = descricao;
	}
	
	public abstract Calcular oberTipoCalculo();
	
}
