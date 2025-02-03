package br.com.cotiinformatica.infrastructure.messages;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cotiinformatica.domain.contracts.components.EmailMessage;
import br.com.cotiinformatica.domain.models.dtos.ClienteResponseDto;
import br.com.cotiinformatica.domain.models.dtos.EmailMessageDto;

@Component
public class EmailMessageImpl implements EmailMessage {
	
	@Autowired RabbitTemplate rabbitTemplate;
	@Autowired ObjectMapper objectMapper;
	@Autowired Queue queue;

	@Override
	public void criarEmail(ClienteResponseDto cliente, String assunto, String mensagem) {
		
		var emailMessageDto = new EmailMessageDto();
		emailMessageDto.setId(UUID.randomUUID());
		emailMessageDto.setCliente(cliente);
		emailMessageDto.setAssunto(assunto);
		emailMessageDto.setMensagem(mensagem);
		
		try {
			var json = objectMapper.writeValueAsString(emailMessageDto);
			rabbitTemplate.convertAndSend(queue.getName(), json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
