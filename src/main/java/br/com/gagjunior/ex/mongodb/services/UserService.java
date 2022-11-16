package br.com.gagjunior.ex.mongodb.services;

import br.com.gagjunior.ex.mongodb.entities.User;
import br.com.gagjunior.ex.mongodb.repositories.UserRepository;
import br.com.gagjunior.ex.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
