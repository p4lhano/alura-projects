package dev.palhano.threadsdb;

public class TaskAcessoBanco implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TaskAcessoBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (pool) {
			System.out.println("Captured key pool");
			pool.getConnection();
			synchronized (tx) {
				System.out.println("Captured key gerenciador");
			}
		}
		
		
	}

}
