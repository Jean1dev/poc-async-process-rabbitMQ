package com.consumer.service;

import com.consumer.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    public void action(Message message) {
        System.out.println(message.getText());
    }
}
