package br.com.pierre.pedido.notificacao.service;


import com.pierre_api.services_1.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void emviarEmail(Pedido pedido) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("Pedidos-Api@compagny");
        simpleMailMessage.setTo(pedido.getEmailNotificacao());
        simpleMailMessage.setSubject("Pedido de compras");
        simpleMailMessage.setText(this.gerarMessagem(pedido));
        mailSender.send(simpleMailMessage);

    }

    private String gerarMessagem(Pedido pedido) {
       String pedidoId =  pedido.getId().toString();
       String client = pedido.getCliente();
       String valor =  String.valueOf(pedido.getValorTotal());
       String status = pedido.getStatus().name();

        return String.format("Ola %s seu pedido de n' %s no valor de %s, foi realizado com sucesso.\nStatus: %s. ", client, pedidoId, valor, status);
    }


}
