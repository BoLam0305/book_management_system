package com.example.testgraphql.repositories;

import com.example.testgraphql.modules.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
