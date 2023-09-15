package com.example.testgraphql.repositories;

import com.example.testgraphql.modules.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

	List<Author>findByIdIn(List<Integer> authorIds);
}
