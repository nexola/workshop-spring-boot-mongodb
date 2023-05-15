package com.nexola.workshopmongo.resources;

import com.nexola.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController // Retorna os dados como Json ou XML
@RequestMapping(value = "/users") // Caminho do endpoint
public class UserResource {

    @GetMapping // Método GET, para retornar os valores
    public ResponseEntity<List<User>> findAll() { // Buscar todos os usuários
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User alex = new User("2", "Alex Macedo", "alex@gmail.com");
        return ResponseEntity.ok().body(new ArrayList<>(Arrays.asList(maria, alex)));
    }
}
