package com.linocks.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.linocks.graphql.model.Book;
import com.linocks.graphql.service.BookService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final BookService bookService;


    public List<Book> allBooks(){
        return bookService.allBooks();
    }
}
