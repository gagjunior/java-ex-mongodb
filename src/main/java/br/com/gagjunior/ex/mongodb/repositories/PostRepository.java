package br.com.gagjunior.ex.mongodb.repositories;

import br.com.gagjunior.ex.mongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
