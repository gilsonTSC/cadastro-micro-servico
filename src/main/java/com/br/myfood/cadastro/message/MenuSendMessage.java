package com.br.myfood.cadastro.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.br.myfood.cadastro.dto.MenuOrderDto;

@Component
public class MenuSendMessage {

	@Value("${cadastro.rabbitmq.exchange}")
    private String exchange;

    @Value("${adastro.menu.rabbitmq.routingkey}")
    private String routingkey;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MenuSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MenuOrderDto menu) {
        System.out.println(menu);
        System.out.println(exchange);
        System.out.println(routingkey);
        rabbitTemplate.convertAndSend(exchange, routingkey, menu);
    }
    
}