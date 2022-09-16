import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class JavaIO {
	public static void main(String[] args) throws IOException {
//		Refencia da conexão com o arquivo  = de onde realmente vem a conexão, pode ser o console,rede ou como nesse caso uma saida stream para arquivo.
		FileOutputStream fos                 = new FileOutputStream("lorem2.txt");
//		tambem poderia ser: OutputStream fos
		
//		informação que a conexão antes criada com stream é possivel transforma-la serializavel em caracteres
		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		tambem poderia ser: Writer osw
		
		
//		Que os caracteres antes declarados, serão escritos não um a um, mas por sequecias de String, utilizando metodos de bufferilialização
		BufferedWriter bw = new BufferedWriter(osw);
//		tambem poderia ser Writer bw
		
		bw.write("Lorem ipsum dolor sit amet");
		bw.close();
		
//		utizado assim o Decorator
//		Forma simplificada de fazer o que foi feito acima, considerando que seria uma saida de texto
		
		FileWriter fw = new FileWriter("arquivo.txt");
		fw.write("Lorem ipsum dolor sit amet");
		fw.close();
		
//		Ou
		
		PrintWriter out = new PrintWriter("lorem2.txt");
		out.println("Lorem ipsum dolor sit amet");
		out.close();
		
	}
}
