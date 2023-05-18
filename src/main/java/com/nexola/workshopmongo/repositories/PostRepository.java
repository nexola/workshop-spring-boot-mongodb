package com.nexola.workshopmongo.repositories;

import com.nexola.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indica ao spring que é um repositório
public interface PostRepository extends MongoRepository<Post, String> { // MongoRepository<Objeto, Tipo do ID>

    List<Post> findByTitleContainingIgnoreCase(String text); // Query method

}
