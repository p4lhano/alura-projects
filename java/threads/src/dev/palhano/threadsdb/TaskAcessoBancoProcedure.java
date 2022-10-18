package dev.palhano.threadsdb;

public class TaskAcessoBancoProcedure implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TaskAcessoBancoProcedure(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (tx) {
			System.out.println("Captured key gerenciador");
			pool.getConnection();
			synchronized (pool) {
				System.out.println("Captured key pool");
			}
		}
		
		
	}

}
