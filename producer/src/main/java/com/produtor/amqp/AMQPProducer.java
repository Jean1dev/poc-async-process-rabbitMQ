package com.produtor.amqp;

public interface AMQPProducer<T> {

    void producer(T t);
}
