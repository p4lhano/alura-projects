package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {
    @RabbitListener(queues = "pagamento.detalhes-pedidos")
    public  void recebeMenssagem (@Payload PagamentoDto pagamento){

        System.out.println("Recebido"+pagamento.toString());
    }
}
