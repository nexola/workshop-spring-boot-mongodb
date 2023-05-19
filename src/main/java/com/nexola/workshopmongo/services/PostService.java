package com.nexola.workshopmongo.services;

import com.nexola.workshopmongo.domain.Post;
import com.nexola.workshopmongo.repositories.PostRepository;
import com.nexola.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service // Indica ao spring que é um service
public class PostService {

    @Autowired // Instancia o objeto automaticamente
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        maxDate = maxDate.plusDays(1);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}