package com.linocks.graphql.repository;

import com.linocks.graphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
