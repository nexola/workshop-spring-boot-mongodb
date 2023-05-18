package com.nexola.workshopmongo.resources;

import com.nexola.workshopmongo.domain.Post;
import com.nexola.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Retorna os dados como Json ou XML
@RequestMapping(value = "/posts") // Caminho do endpoint
public class PostResource {

    @Autowired
    private PostService postService;


    @GetMapping(value = "/{id}") // Método GET, para retornar valores
    public ResponseEntity<Post> findById(@PathVariable String id)  { // Buscar todos os usuários
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
