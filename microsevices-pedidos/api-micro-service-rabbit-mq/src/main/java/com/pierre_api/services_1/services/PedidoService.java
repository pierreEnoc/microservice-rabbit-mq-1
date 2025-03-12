package com.pierre_api.services_1.services;


import com.pierre_api.services_1.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class PedidoService {

    private final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    //@Autowired
   //private RabbitTemplate rabbitTemplate;

    //injecao de dependencia viar constructor
private final RabbitTemplate rabbitTemplate;
    public PedidoService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public Pedido enfileirarPedido(Pedido pedido) {
        rabbitTemplate.convertAndSend(exchangeName,"", pedido);
        logger.info("Pedido enfileira:{}", pedido.toString());
        return pedido;
    }

}
