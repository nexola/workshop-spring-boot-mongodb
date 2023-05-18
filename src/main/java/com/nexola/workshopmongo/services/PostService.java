package com.nexola.workshopmongo.services;

import com.nexola.workshopmongo.domain.Post;
import com.nexola.workshopmongo.repositories.PostRepository;
import com.nexola.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Indica ao spring que é um service
public class PostService {

    @Autowired // Instancia o objeto automaticamente
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}