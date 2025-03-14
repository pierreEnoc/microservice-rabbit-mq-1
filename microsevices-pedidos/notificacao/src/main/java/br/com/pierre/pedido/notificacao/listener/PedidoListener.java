package br.com.pierre.pedido.notificacao.listener;


import com.pierre_api.services_1.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PedidoListener {

    private final Logger logger = LoggerFactory.getLogger(PedidoListener.class);

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
   public void enviarNotificacao(Pedido pedido) {
        logger.info("Notificacao gerada: {}", pedido.toString());

   }

}
