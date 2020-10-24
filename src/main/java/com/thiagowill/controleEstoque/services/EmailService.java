package com.thiagowill.controleEstoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private EmailPedidoService emailService;
	
    public String sendMail(String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Pedido madeira");
        message.setText(msg);
        message.setTo(emailService.findEmail().getEmailDestino());
        message.setFrom("thiagopompeu19@gmail.com");

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
	
}
