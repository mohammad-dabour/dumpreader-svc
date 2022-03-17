package io.dataloder.dumpreader;

import java.nio.file.Path;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import io.dataloder.dumpreader.author.Author;
import io.dataloder.dumpreader.author.AuthorRepository;
import io.dataloder.dumpreader.connection.DatastaxAstraConfigs;

@SpringBootApplication
@EnableConfigurationProperties(DatastaxAstraConfigs.class)
public class DumpreaderApplication {

	@Autowired private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(DumpreaderApplication.class, args);
	}

	@PostConstruct
	public void start(){


		Author author = new Author();
		author.setId("1");
		author.setName("Mohammad Mustafa");

		authorRepository.save(author);
		System.out.println("App just started");
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DatastaxAstraConfigs dataAstraProperties){
		Path bundle = dataAstraProperties.getSecureConnectionBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}

}
