package com.example.testgraphql.repositories;

import com.example.testgraphql.modules.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByAuthorIdIn(List<Integer>authorIds);
}
