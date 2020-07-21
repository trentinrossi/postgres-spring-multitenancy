package br.com.fullcustom.postgresmultitenancy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fullcustom.postgresmultitenancy.domain.Author;
import br.com.fullcustom.postgresmultitenancy.repository.AuthorRepository;
import br.com.fullcustom.postgresmultitenancy.services.exceptions.ObjectNotFoundException;

@Service
public class AuthorService {

    @Autowired
    public AuthorRepository repository;

    public List<Author> findAll() {
        return repository.findAll();
    }

    public Author findById(Long id) {
        Optional<Author> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Author insert(Author obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public Author update(Author obj) {
        Author newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Author newObj, Author obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}