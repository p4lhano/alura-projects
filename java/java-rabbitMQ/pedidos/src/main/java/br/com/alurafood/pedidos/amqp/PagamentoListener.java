package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {
    @RabbitListener(queues = "pagamento.detalhes-pedidos")
    public  void recebeMenssagem (PagamentoDto pagamento){

        System.out.println("Recebido"+pagamento.toString());
    }
}
