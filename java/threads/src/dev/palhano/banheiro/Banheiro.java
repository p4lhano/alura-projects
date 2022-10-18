package dev.palhano.banheiro;

public class Banheiro {
	
	private boolean isSujo=true;
	
	public void numberOne() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" pediu para entrar no banheiro");
		synchronized (Banheiro.this) {
			System.out.println(name+" entrou no banheiro");
			if(isSujo) 
				aguardarLimpeza(name);
			
				
				
			System.out.println("Fazendo xixi/" + name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			limpar("xixi/"+name);
		}
		
	}
	public void numberTwo() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" pediu para entrar no banheiro");
		synchronized (this) { //esse obejto esse trecho de código só será executado quando o obejto presente estiver disponivel apenas para mim
			System.out.println(name+" entrou no banheiro");
			while(isSujo) 
				aguardarLimpeza(name);
			System.out.println("Fazendo coco/"+name);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			limpar("coco/"+name);
		}
	}
	
	private void limpar(String acao) {
		System.out.println("Danco descarga em " + acao );
		System.out.println("Lavando e sencando mão-"+ acao );
		this.isSujo=true;
	}
	
	private void aguardarLimpeza(String nome) {
		System.out.println(nome+": Esta sujo, volto depois");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void limparBanheiro() {
		
		String name = Thread.currentThread().getName();
		System.out.println(name+" pediu para entrar no banheiro");
		synchronized (this) {
			System.out.println(name+" entrou no banheiro");
			if(!isSujo) {
				System.out.println("Não esta sujo");
				return;
			}
			System.out.println("Banheiro esta sendo limpo");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.isSujo=false;
			
			System.out.println("Terminou limpeza");
			
			this.notifyAll();
		}
	}
}
