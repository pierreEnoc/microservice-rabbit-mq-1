package com.pierre.api.pedidos.processador.listener;

import com.pierre.api.pedidos.processador.entity.Pedido;
import com.pierre.api.pedidos.processador.entity.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-processamento")
    public void salvarPedido(Pedido pedido) {
        pedido.setStatus(Status.PROCESSADO);
        logger.info("Pedido processado:{}", pedido.toString());
    }
}
