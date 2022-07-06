package io.enfuse.rabbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.amqp.core.Queue;

public class Sender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public Sender() {
        System.out.println("created sender");
    }

    @Scheduled(fixedDelay = 1000)
    public void send() {
        String message = "Pretty interesting message";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
