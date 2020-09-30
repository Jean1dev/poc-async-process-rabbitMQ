package com.produtor.resource;

import com.produtor.amqp.ProducerRabbitMQ;
import com.produtor.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private ProducerRabbitMQ producer;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void send(@RequestBody Message message) {
        producer.producer(message);
    }
}
