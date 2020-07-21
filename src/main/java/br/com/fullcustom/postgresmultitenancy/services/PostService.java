package br.com.fullcustom.postgresmultitenancy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullcustom.postgresmultitenancy.domain.Post;
import br.com.fullcustom.postgresmultitenancy.repository.PostRepository;
import br.com.fullcustom.postgresmultitenancy.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(Long id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findAll() {
        return repo.findAll();
    }
}