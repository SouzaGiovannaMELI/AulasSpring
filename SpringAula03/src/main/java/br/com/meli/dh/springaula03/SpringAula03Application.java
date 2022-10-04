package br.com.meli.dh.springaula03;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class SpringAula03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAula03Application.class, args);
		log.printf(Level.INFO, "Informação");
		log.printf(Level.WARN, "Warning");
		log.printf(Level.ERROR, "Error");

	}

}
