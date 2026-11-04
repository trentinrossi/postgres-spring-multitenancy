package br.com.fullcustom.postgresmultitenancy.config;

import java.text.SimpleDateFormat;
import java.util.List;
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
        var sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postReposiroty.deleteAll();

        var maria = new Author(null, "Maria Brown", "maria@gmail.com");
        var alex = new Author(null, "Alex Green", "alex@gmail.com");
        var bob = new Author(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(maria, alex, bob));

        var post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SÃ£o Paulo. AbraÃ§os!", maria);
        var post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", maria);

        postReposiroty.saveAll(List.of(post1, post2));

        maria.getPosts().addAll(List.of(post1, post2));
        userRepository.save(maria);
    }
}