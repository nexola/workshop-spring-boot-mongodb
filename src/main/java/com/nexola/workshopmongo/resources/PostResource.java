package com.nexola.workshopmongo.resources;

import com.nexola.workshopmongo.domain.Post;
import com.nexola.workshopmongo.resources.util.URL;
import com.nexola.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Retorna os dados como Json ou XML
@RequestMapping(value = "/posts") // Caminho do endpoint
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id)  {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text)  {

        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
