package dev.palhano.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server {
	
	public static final int PORT_SERVER=8085;
	private ExecutorService executorPool;
	private ServerSocket serverSocket;
	
	/**
	 * volatile desabilita o acesso ao atributo via cacheamento de Threads em memória.
	 * Ao inves de seguir o compamento padrão da JVM de realizar uma cópia dos atributos para 
	 * cada Thread, informa que o acesso será unico nesta posição de mem, assim todos irão buscas a informação
	 * do mesmo lugar
	 * */
	private volatile boolean isRun = true; 
	/**
	 * Introduzido pelo java.util.concurrent tem o mesmo sentido do volatile, de acesso unico entre as diferentes threads
	 * 
	 * */
	private AtomicBoolean isRunAtomic = new AtomicBoolean(isRun);
	
	private BlockingQueue<String> filaComandos;
	
	public Server() {
		try {
			System.out.println("Iniciando server");
			this.serverSocket = new ServerSocket(PORT_SERVER);
			this.executorPool = Executors.newCachedThreadPool(new ThreadFactory());
			
			this.filaComandos = new ArrayBlockingQueue<>(3);
			
			this.runConsumers();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	private void run() throws Exception {
		try {
			while (this.isRun) {
				Socket accept = serverSocket.accept();
				System.out.println("Cliente aceito port: " + accept.getPort());
				System.out.println("Cliente aceito portLocal: " + accept.getLocalPort());

				TaskDestribuir task = new TaskDestribuir(accept, this , this.executorPool, this.filaComandos);

				executorPool.execute(task);
				
			} 
		} catch (SocketException e) {
			System.out.println("Desligamento encontrou isRun: "+isRun);
		}
	}

	
	private void runConsumers() {		
		for (int i = 0; i < 2; i++) {
			TaskConsumer consumer = new TaskConsumer(filaComandos);
			this.executorPool.execute(consumer);
		}	
	}
	
	public void shutdown() throws Exception {
		this.executorPool.shutdown();
		this.serverSocket.close();
		this.isRun=false;
		System.out.println("Servidor desligado");
	}

	public static void main(String[] args) throws Exception {
		
		Server server = new Server();
		server.run();
		server.shutdown();
		
	}

}
