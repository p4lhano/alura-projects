package dev.palhano.banheiro;

public class TareTwo implements Runnable {
	
	private Banheiro banheiro;
	
	public TareTwo(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		banheiro.numberTwo();
	}

}
