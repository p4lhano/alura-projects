package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	
	//Strategy
	A_DESEJAR {
		@Override
		public BigDecimal percentReajust() {
			return new BigDecimal("0.03");
		}
	},
	BOM {
		@Override
		public BigDecimal percentReajust() {
			return new BigDecimal("0.15");
		}
	},
	OTIMO {
		@Override
		public BigDecimal percentReajust() {
			return new BigDecimal("0.20");
		}
	};
	
	public abstract BigDecimal percentReajust();
}
