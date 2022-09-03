package br.com.bytebank.banco.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Teste de ordenação
 * Le
 * 
 * @author Vitor
 *
 */
public abstract class ClasseAnonimaForConta {

    //Uso de Lambdas e classe anonimas
    public static void main(String[] args) {
		List<Conta> list = new ArrayList<Conta>();
		list.add(new ContaCorrente(11, 11));
		list.add(new ContaCorrente(13, 12));
		list.add(new ContaCorrente(12, 13));
		//Deve ser utilizado um Funciotion obj devido a ter que ter uma impletanção de Comparator,
//		utilizado via classe anonima pois só vai ser utilizado uma vez
		list.sort(new Comparator<Conta>() {	// Classe anonima. Vai criar um Classe tmp que realmente vai ser
											// tornar um obj que pode ser instanciado. Ao inves da interface Camparator
			
			@Override
			public int compare(Conta arg0, Conta arg1) {
		
				return Integer.compare(arg0.getAgencia(), arg1.getAgencia());
			} 		
		});
		
	}

}