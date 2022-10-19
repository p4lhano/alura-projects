package dev.palhano.cliente;

import java.net.Socket;

import dev.palhano.server.Server;

public class ClienteMain {

	public static void main(String[] args) {
		
		try(Socket socket = new Socket( "localhost" , Server.PORT_SERVER )) {
			
			System.out.println("Conexão estabelecida");
			
			Thread threadEnvio = new Thread(new TaskEnvio(socket),"TaskEnvio");
			
			Thread threadRespota = new Thread(new TaskResposta(socket),"TaskResposta");
			
			threadEnvio.start();
			threadRespota.start();
			
			threadEnvio.join();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		
		
		
	}

}
