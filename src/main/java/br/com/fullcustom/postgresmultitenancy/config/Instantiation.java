package br.com.fullcustom.postgresmultitenancy.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fullcustom.postgresmultitenancy.domain.Author;
import br.com.fullcustom.postgresmultitenancy.domain.Post;
import br.com.fullcustom.postgresmultitenancy.repository.AuthorRepository;
import br.com.fullcustom.postgresmultitenancy.repository.PostRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private AuthorRepository userRepository;

    @Autowired
	private PostRepository postReposiroty;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postReposiroty.deleteAll();

        Author maria = new Author(null, "Maria Brown", "maria@gmail.com");
        Author alex = new Author(null, "Alex Green", "alex@gmail.com");
        Author bob = new Author(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);                

        postReposiroty.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));        
		userRepository.save(maria);
    }

}