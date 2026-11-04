package br.com.fullcustom.postgresmultitenancy.resources

import java.net.URI
import java.util.List

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import br.com.fullcustom.postgresmultitenancy.domain.Author
import br.com.fullcustom.postgresmultitenancy.domain.Post
import br.com.fullcustom.postgresmultitenancy.services.AuthorService

RestController
RequestMappingvalue  authors
public class AuthorResource 

Autowired
private AuthorService service

GetMapping
public ResponseEntityListAuthor findAll 
ListAuthor list  service.findAll
return ResponseEntity.ok.bodylist


GetMappingpath  id
public ResponseEntityAuthor findByIdPathVariable Long id 
Author obj  service.findByIdid
return ResponseEntity.ok.bodyobj


PostMapping
public ResponseEntityVoid insertRequestBody Author obj 
obj  service.insertobj
URI uri  ServletUriComponentsBuilder.fromCurrentRequest.pathid.buildAndExpandobj.getId.toUri
return ResponseEntity.createduri.build


DeleteMappingpath  id
public ResponseEntityVoid deletePathVariable Long id 
service.deleteid
return ResponseEntity.noContent.build


PutMappingpath  id
public ResponseEntityVoid updateRequestBody Author obj, PathVariable Long id 
obj.setIdid
obj  service.updateobj
return ResponseEntity.noContent.build


GetMappingpath  idposts
public ResponseEntityListPost findPostsPathVariable Long id 
Author obj  service.findByIdid
return ResponseEntity.ok.bodyobj.getPosts