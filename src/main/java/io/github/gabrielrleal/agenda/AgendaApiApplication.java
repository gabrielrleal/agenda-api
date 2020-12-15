package io.github.gabrielrleal.agenda;

import io.github.gabrielrleal.agenda.model.entity.Contato;
import io.github.gabrielrleal.agenda.model.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgendaApiApplication {

	@Bean
	public CommandLineRunner commandLineRunner(//interface que permite que execute um código (precisa de @bean) assim que a aplicação iniciar
			@Autowired ContatoRepository repository){
		return args -> {
			Contato contato = new Contato();
			contato.setNome("fulano");
			contato.setEmail("fulano@email.com");
			contato.setFavorito(false);
			repository.save(contato);

		};



	}

	public static void main(String[] args) {
		SpringApplication.run(AgendaApiApplication.class, args);
	}

}
