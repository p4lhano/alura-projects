package dev.palhano.busca_textual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nomeBuscar;
	
	public BuscaTextual(String nomeArquivo,String nomeBuscar) {
		this.nomeArquivo = nomeArquivo;
		this.nomeBuscar = nomeBuscar;
	}
	
	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(nomeArquivo));
			int numLinha=1;
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				if (linha.contains(nomeBuscar))
					System.out.println(nomeArquivo + " - " + numLinha+"-> "+linha);
				
				numLinha++;
			}
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}

}
