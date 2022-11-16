package br.com.gagjunior.ex.mongodb.resources;

import br.com.gagjunior.ex.mongodb.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User teste = new User("1", "Fulano", "fulano@hotmail.com");
        User teste1 = new User("2", "Ciclano", "ciclano@hotmail.com");
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(teste, teste1));
        return ResponseEntity.ok(users);
    }
}
