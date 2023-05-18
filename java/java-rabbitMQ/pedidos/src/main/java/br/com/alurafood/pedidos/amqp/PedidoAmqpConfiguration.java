package br.com.alurafood.pedidos.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoAmqpConfiguration {
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public Queue createQueueDetalhePedido() {
        return QueueBuilder
                .nonDurable("pagamento.detalhes-pedidos")
                .deadLetterExchange("pagamento.dlx")
                .build();
    }
    @Bean
    public Queue queueDlqDetalhePedido() {
        return QueueBuilder
                .nonDurable("pagamento.detalhes-pedidos-dlq")
                .build();
    }
    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("pagamento.ex").build();
    }
    @Bean
    public FanoutExchange deadLetterExchange() {
        return ExchangeBuilder.fanoutExchange("pagamento.dlx").build();
    }
    @Bean
    public Binding bindingDetalhePagamentoPedido() {
        return BindingBuilder.bind(createQueueDetalhePedido())
                .to(fanoutExchange());
    }
    @Bean
    public Binding bindingDlxPagamentoPedido() {
        return BindingBuilder.bind(queueDlqDetalhePedido())
                .to(deadLetterExchange());
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public RabbitAdmin createRabbitAdmin(ConnectionFactory conn) {
        return new RabbitAdmin(conn);
    }
}
