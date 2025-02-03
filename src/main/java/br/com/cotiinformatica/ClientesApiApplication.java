package br.com.cotiinformatica;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit //ativação do serviço de mensageria
@SpringBootApplication
public class ClientesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesApiApplication.class, args);
	}

}
