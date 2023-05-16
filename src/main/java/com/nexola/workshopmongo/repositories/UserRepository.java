package com.nexola.workshopmongo.repositories;

import com.nexola.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica ao spring que é um repositório
public interface UserRepository extends MongoRepository<User, String> { // MongoRepository<Objeto, Tipo do ID>
}
