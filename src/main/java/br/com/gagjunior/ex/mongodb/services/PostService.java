package br.com.gagjunior.ex.mongodb.services;

import br.com.gagjunior.ex.mongodb.domain.Post;
import br.com.gagjunior.ex.mongodb.repositories.PostRepository;
import br.com.gagjunior.ex.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        maxDate = maxDate.plusDays(1);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
