package com.emailMS3.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailMS3.models.Email;
import com.emailMS3.repositories.EmailRepository;

@RestController
@RequestMapping("/email")
public class EmailController {


	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;

	@PostMapping
	public ResponseEntity<Email> enviar(@RequestBody Email model) {
		if (model == null) {
			return new ResponseEntity("Os dados para o envio de email não foram informados!", HttpStatus.BAD_REQUEST);
		}

		Optional<Email> email = emailRepository.findById(model.getIdEmail());

		if (!email.isPresent()) {
			return new ResponseEntity("O email informado não existe!" , HttpStatus.NOT_FOUND);
		}

		SimpleMailMessage emailEnvio = new SimpleMailMessage();

		try {
			
			emailEnvio.setFrom(email.get().getRemetente());
			emailEnvio.setTo(email.get().getDestinatario());
			emailEnvio.setSubject(email.get().getAssunto());
			emailEnvio.setText(email.get().getHtmlCorpo());
			email.get().setDtEnvio(new Date());

			emailSender.send(emailEnvio);
		} catch (MailException ex) {
			email.get().setSucesso(false);
			emailRepository.save(email.get());
			return new ResponseEntity<Email>(email.get(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		email.get().setSucesso(true);
		emailRepository.save(email.get());
		return new ResponseEntity(HttpStatus.OK);
	}
}
