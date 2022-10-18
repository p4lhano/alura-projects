package dev.palhano.banheiro;

public class TareLimpar implements Runnable {
	
	private Banheiro banheiro;
	
	public TareLimpar(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			banheiro.limparBanheiro();
			
		}
		
	}

}
