package co.essejacques.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void send(String exchange, String routingKey, Object message) {
        log.info("Sending message to exchange {} with routing key {}", exchange, routingKey);
        amqpTemplate.convertAndSend(exchange, routingKey, message);
        log.info("Sent message to exchange {} with routing key {}", exchange, routingKey);
    }
}
