package dev.palhano.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.palhano.mudi.model.Pedido;
import dev.palhano.mudi.model.Dto.PedidoFormDto;
import dev.palhano.mudi.repository.PedidoRepository;

@Controller
@RequestMapping(value = "pedido")
public class PedidoController {
	
	private final PedidoRepository pedidoRepository;
	private final HomeController homeController;
	
	public PedidoController(PedidoRepository pedidoRepository,HomeController homeController) {
		this.pedidoRepository = pedidoRepository;
		this.homeController = homeController;
	}
	
	
	@GetMapping("novo")
	public String sendFormulario(PedidoFormDto pedidoFormDto) {
//		INSERT INTO pedido (data_entrega, descricao, nome, url_image, url_produto, valor_negociado) VALUES('2022-10-04', 'Google Pixel 6 128Gb Preto 8Gb Ram Preto', 'Google Pixel 6', 'https://imgs.casasbahia.com.br/1532236149/1xg.jpg', 'https://www.casasbahia.com.br/telefones-celulares/smartphones/android/google-pixel-6-128gb-preto-8gb-ram-preto-1532236149.html', 5449.00);
		
//		Gambiarra emergencial pq não estava pegando o thymeleaf não estava criando instancia vazia da classe no HTML para preenciamento do for
//		if (null == model.getAttribute("pedidoFormDto"))
//			model.addAttribute(new PedidoFormDto());
		
		return "pedido/novo";
	}
	
	@PostMapping(value = "novo")
	public String saveByForm(@Validated PedidoFormDto pedidoFormDto,BindingResult result,Model model) {
		System.err.println(result.hasErrors() + " -> " + pedidoFormDto);
		
		if(result.hasErrors())
			return this.sendFormulario(pedidoFormDto);
		
		Pedido pedido = pedidoFormDto.toPedido();
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}
