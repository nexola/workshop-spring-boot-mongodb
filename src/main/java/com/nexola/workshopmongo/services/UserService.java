package com.nexola.workshopmongo.services;

import com.nexola.workshopmongo.domain.User;
import com.nexola.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica ao spring que é um service
public class UserService {

    @Autowired // Instancia o objeto automaticamente
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
