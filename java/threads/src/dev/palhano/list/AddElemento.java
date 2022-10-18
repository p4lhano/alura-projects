package dev.palhano.list;

import java.util.List;

public class AddElemento implements Runnable {

	private String name;
	private List<String> list;

//	private Lista list;
//	public AddElemento(Lista lista, String name) {
//		this.list = lista;
//		this.name = name;
//	}

	public AddElemento(List<String> list, String name) {
		this.list = list;
		this.name = name;
	}

	@Override
	public void run() {
		String nameT = Thread.currentThread().getName();
		for (int i = 0; i < 100; i++) {
//			lista.adicionaElementos("T:"+nameT+"->"+name+" Element_"+i);
			list.add("T:"+nameT+"->"+name+" Element_"+i);
		}
	}

}
