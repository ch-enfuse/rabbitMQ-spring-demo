package io.enfuse.rabbitmqdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqDemoApplication {

	@Profile("usage_message")
	@Bean
	public CommandLineRunner usage() {
		return args -> {
			System.out.println("This app uses Spring Profiles to " +
					"control its behavior.\n");
					System.out.println("Sample usage: java -jar " +
							"rabbit-tutorials.jar " +
							"--spring.profiles.active=hello-world,sender");
		};
	}

	@Profile("!usage_message")
	@Bean
	public CommandLineRunner tutorial() {
		return new RabbitMQRunner();
	}
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqDemoApplication.class, args);
	}

}
