package br.com.bytebank.banco.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClasseForUsesLambdas {


    //Uso de Lambdas e classe anonimas
    public static void main(String[] args) {
		List<Conta> list = new ArrayList<Conta>();
		list.add(new ContaCorrente(11, 11));
		list.add(new ContaCorrente(13, 12));
		list.add(new ContaCorrente(12, 13));
		
		//Deve ser utilizado um Funciotion obj devido a ter que ter uma impletanção de Comparator,
//		utilizado via lambda pois só vai ser utilizado uma vez
		
		list.sort(( Conta arg0, Conta arg1) -> {
			//outra intrução
				return Integer.compare(arg0.getAgencia(), arg1.getAgencia());
			});
		
		list.forEach(c -> System.out.println(c) );
		
//		Por baixo dos panos será implementado uma classe anonima
//		Lambdas quando tem mais de uma instruções devem ser utilizadas como acima, mas
//		Caso tenha somente uma instrução para execução pode ser utilizado como abaixo
		
		list.sort((c1, c2) -> Integer.compare( c1.getNumero(), c2.getNumero() ));
		
		list.forEach(c -> System.out.println(c) );
		
	}

}
