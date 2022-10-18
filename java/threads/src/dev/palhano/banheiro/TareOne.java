package dev.palhano.banheiro;

public class TareOne implements Runnable {
	
	private Banheiro banheiro;
	
	public TareOne(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		banheiro.numberOne();
	}

}
