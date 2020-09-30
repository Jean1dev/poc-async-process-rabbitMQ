package com.consumer.amqp;

import com.consumer.dto.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitConsumer2 {

    @RabbitListener(queues = "fila-2-teste")
    public void consumer(Message message) {
        System.out.println("segunda fila" + message);
    }
}
