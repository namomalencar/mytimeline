package br.com.namom.mytimeline.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application.
 * 
 * @author Namom Alencar {@literal <namomalencar@gmail.com>}
 * @version 1.0
 * @since 1.0
 */
@SpringBootApplication
@ComponentScan({ "com.namom.mytimeline", "br.com.namom.mytimeline" })
@EnableJpaRepositories({ "com.namom.mytimeline", "br.com.namom.mytimeline" })
@EntityScan({ "com.namom.mytimeline", "br.com.namom.mytimeline" })
public class App {

	private static Class<App> applicationClass = App.class;

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
}
