package br.com.gagjunior.ex.mongodb.config;

import br.com.gagjunior.ex.mongodb.domain.Post;
import br.com.gagjunior.ex.mongodb.domain.User;
import br.com.gagjunior.ex.mongodb.domain.dto.AuthorDTO;
import br.com.gagjunior.ex.mongodb.repositories.PostRepository;
import br.com.gagjunior.ex.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.of("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,
                LocalDate.parse("21/03/2018", fmt),
                "Partiu viagem",
                "Vou viajar para São Paulo. Abraços",
                new AuthorDTO(maria));
        Post post2 = new Post(null,
                LocalDate.parse("23/03/2018", fmt),
                "Bom dia",
                "Acordei feliz hoje",
                new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1, post2));

    }

}
