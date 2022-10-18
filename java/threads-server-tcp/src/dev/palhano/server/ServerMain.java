package dev.palhano.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {
	
	public static final int PORT_SERVER=8085;

	public static void main(String[] args) throws Exception {
		
		System.out.println("Iniciando server");
		ServerSocket serverSocket = new ServerSocket(PORT_SERVER);
		
//		ExecutorService executorPool = Executors.newFixedThreadPool(2);
		ExecutorService executorPool = Executors.newCachedThreadPool();
		while (true) {
			Socket accept = serverSocket.accept();
			System.out.println("Cliente aceito port: "+accept.getPort());
			System.out.println("Cliente aceito portLocal: "+accept.getLocalPort());
			
			TaskDestribuir task = new TaskDestribuir(accept);
			
			executorPool.execute(task);
			
//			Thread thread = new Thread(task);
//			thread.start();
			
		}
		
	}

}
