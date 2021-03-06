package com.produtor.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ProducerConfiguration {

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.deadletter.producer}")
    private String deadLetter;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue deadLetter() {
        return new Queue(deadLetter);
    }

    @Bean
    public Queue queue() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", exchange);
        args.put("x-dead-letter-rousting-key", deadLetter);

        return new Queue(queue, true, false, false, args);
    }

    @Bean
    public Binding binding(DirectExchange exchange) {
        return BindingBuilder.bind(queue())
                .to(exchange)
                .with(queue);
    }

    @Bean
    public Binding binding2(DirectExchange exchange) {
        String queue2 = "fila-2-teste";
        return BindingBuilder.bind(new Queue(queue2, true, false, false))
                .to(exchange)
                .with(queue2);
    }

    @Bean
    public Binding bindingDeadLetter(DirectExchange exchange) {
        return BindingBuilder.bind(deadLetter())
                .to(exchange)
                .with(deadLetter);
    }
}
