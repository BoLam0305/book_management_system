package com.example.testgraphql.repositories;

import com.example.testgraphql.modules.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book>findByIdIn(List<Integer> bookIds);

}
