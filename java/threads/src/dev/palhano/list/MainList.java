package dev.palhano.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainList {
	public static void main(String[] args) {
//		Lista lista = new Lista();
//		
//		for (int i = 0; i < 10; i++) {
//			new Thread(new AddElemento(lista,"Thread n_"+i)).start();
//		}
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		for (int i = 0; i < lista.tamanho(); i++) {
//			System.out.println(i+lista.pegaElemento(i));
//		}
		
		List<String> lista = new Vector<>();//Thread safe
		//java.util.Hashtable para mapas
		for (int i = 0; i < 10; i++) {
			new Thread(new AddElemento(lista,"Thread n_"+i)).start();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i+lista.get(i));
		}
		
		
		
	}
}
