package com.graphql.azurefunctionsspringbootgrapqlexample.repository;

import com.graphql.azurefunctionsspringbootgrapqlexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
