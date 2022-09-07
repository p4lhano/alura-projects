package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	

	public void realizarReajuste(Funcionario funcionario, Desempenho desempenho) {
		
		BigDecimal reajuste ;
		
		switch (desempenho) {
		case A_DESEJAR:
			//Caso a desejar 3%
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
			break;
		case BOM:
			//Caso a desejar 15%
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
			break;
		case OTIMO:
			//Caso a desejar 20%
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
			break;	
		default:
			reajuste = new BigDecimal("0.00");
			break;
		}
		funcionario.ajustSalario(reajuste);
		
	}

}
