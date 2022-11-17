package br.com.gagjunior.ex.mongodb.services;

import br.com.gagjunior.ex.mongodb.dto.UserDTO;
import br.com.gagjunior.ex.mongodb.entities.User;
import br.com.gagjunior.ex.mongodb.repositories.UserRepository;
import br.com.gagjunior.ex.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

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

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @PutMapping
    public User update(User user) {
        User userToUpdate = userRepository.findById(user.getId()).get();
        updateData(userToUpdate, user);
        return userRepository.save(userToUpdate);
    }

    private void updateData(User userToUpdate, User user) {
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setName(user.getName());
    }

    public User fromDTO(UserDTO userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
