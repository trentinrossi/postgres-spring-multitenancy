package br.com.fullcustom.postgresmultitenancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fullcustom.postgresmultitenancy.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}