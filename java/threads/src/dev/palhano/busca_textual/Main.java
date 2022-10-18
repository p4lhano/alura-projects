package dev.palhano.busca_textual;

public class Main {

	public static void main(String[] args) {
		String nome = "Jef";
		
		Thread threadAssinaturas1 = new Thread(new BuscaTextual("nomes/assinaturas1.txt",nome));
		Thread threadAssinaturas2 = new Thread(new BuscaTextual("nomes/assinaturas2.txt",nome));
		Thread threadAutores = new Thread(new BuscaTextual("nomes/autores.txt",nome));
		
		threadAssinaturas1.start();
		threadAssinaturas2.start();
		threadAutores.start();
		
	}

}
