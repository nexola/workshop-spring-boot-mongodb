package com.nexola.workshopmongo.resources;

import com.nexola.workshopmongo.domain.User;
import com.nexola.workshopmongo.dto.UserDTO;
import com.nexola.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}") // Método GET, para retornar os valores
    public ResponseEntity<UserDTO> findById(@PathVariable String id)  { // Buscar todos os usuários
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping // Método GET, para retornar os valores
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto)  { // Buscar todos os usuários
        User obj = userService.fromDTO(objDto);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
