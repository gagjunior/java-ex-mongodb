package br.com.gagjunior.ex.mongodb.repositories;

import br.com.gagjunior.ex.mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
