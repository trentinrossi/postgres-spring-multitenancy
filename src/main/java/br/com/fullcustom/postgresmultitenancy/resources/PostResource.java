package br.com.fullcustom.postgresmultitenancy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fullcustom.postgresmultitenancy.domain.Post;
import br.com.fullcustom.postgresmultitenancy.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(@RequestHeader(name = "X-tenant") String tenant) {
        System.out.println("Tenant: "+tenant);
        List<Post> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
}