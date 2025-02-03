package br.com.cotiinformatica.infrastructure.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
		
	@Value("${queue.name}")
	private String queueName;
	
	@Bean
	Queue queie() {
		return new Queue(queueName,true); //parametro : true --> fila duravel
	}
}