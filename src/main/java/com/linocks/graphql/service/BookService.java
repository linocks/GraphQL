package com.linocks.graphql.service;

import com.linocks.graphql.model.Book;
import com.linocks.graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> allBooks(){
        return bookRepository.findAll();
    }
}
