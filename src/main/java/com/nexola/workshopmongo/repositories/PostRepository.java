package com.nexola.workshopmongo.repositories;

import com.nexola.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository // Indica ao spring que é um repositório
public interface PostRepository extends MongoRepository<Post, String> { // MongoRepository<Objeto, Tipo do ID>

    // https://www.mongodb.com/docs/manual/reference/

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") // ?0 é o primeiro parâmetro passado no método, options i ignora case sensitive
    List<Post> findByTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text); // Query method

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);

}
