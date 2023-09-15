package com.example.testgraphql.repositories;

import com.example.testgraphql.modules.Book;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book>findByIdIn(List<Integer> bookIds);

	@Query("select book from Book book left join Author author on book.author.id = author.id")
	List<Book> findBooksWithAuthors();
}
