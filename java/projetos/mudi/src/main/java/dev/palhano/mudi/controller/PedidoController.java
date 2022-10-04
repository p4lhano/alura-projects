package dev.palhano.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "pedido")
public class PedidoController {
	
	@GetMapping("novo")
	public String sendFormulario() {
//		INSERT INTO pedido (data_entrega, descricao, nome, url_image, url_produto, valor_negociado) VALUES('2022-10-04', 'Google Pixel 6 128Gb Preto 8Gb Ram Preto', 'Google Pixel 6', 'https://imgs.casasbahia.com.br/1532236149/1xg.jpg', 'https://www.casasbahia.com.br/telefones-celulares/smartphones/android/google-pixel-6-128gb-preto-8gb-ram-preto-1532236149.html', 5449.00);

		return "pedido/cadastro";
	}
}
