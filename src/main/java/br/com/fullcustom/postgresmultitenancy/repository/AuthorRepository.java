package br.com.fullcustom.postgresmultitenancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fullcustom.postgresmultitenancy.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}