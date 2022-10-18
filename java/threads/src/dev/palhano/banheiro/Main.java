package dev.palhano.banheiro;

public class Main {
	public static void main(String[] args) {
		
		Banheiro banheiroUnico = new Banheiro();
		
		Thread convidadoJaoT = new Thread(new TareOne(banheiroUnico),"Jão T");
		Thread convidadoMariaT = new Thread(new TareTwo(banheiroUnico),"Maria T");
		Thread limpezaT = new Thread(new TareLimpar(banheiroUnico),"Limpeza");
		limpezaT.setDaemon(true);// Daemon: São provedores de serviços para outras threads
		
		
		convidadoJaoT.start();
		convidadoMariaT.start();
		limpezaT.start();
	}
}
