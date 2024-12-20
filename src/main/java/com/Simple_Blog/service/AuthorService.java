package com.Simple_Blog.service;

import com.Simple_Blog.model.Author;
import com.Simple_Blog.repsitory.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll(){
        return authorRepository.getAll();
    }
}
