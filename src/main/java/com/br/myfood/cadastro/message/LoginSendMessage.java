package com.br.myfood.cadastro.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.br.myfood.cadastro.dto.LoginDto;

@Component
public class LoginSendMessage {

	@Value("${cadastro.rabbitmq.exchange}")
    private String exchange;

    @Value("${cadastro.login.rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public LoginSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(LoginDto login) {
        System.out.println(login);
        System.out.println(exchange);
        System.out.println(routingkey);
        rabbitTemplate.convertAndSend(exchange, routingkey, login);
    }
    
}