package com.consumer.amqp;

import com.consumer.dto.Message;
import com.consumer.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer implements AmqpConsumer<Message> {

    @Autowired
    private ConsumerService service;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(Message message) {
        service.action(message);
    }
}
