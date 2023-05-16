package com.nexola.workshopmongo.resources;

import com.nexola.workshopmongo.domain.User;
import com.nexola.workshopmongo.dto.UserDTO;
import com.nexola.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Retorna os dados como Json ou XML
@RequestMapping(value = "/users") // Caminho do endpoint
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping // Método GET, para retornar os valores
    public ResponseEntity<List<UserDTO>> findAll() { // Buscar todos os usuários
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).toList(); // Transforma os usuarios da lista em usersDTO
        return ResponseEntity.ok().body(listDto);
    }
}
