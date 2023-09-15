package com.example.testgraphql.repositories;

import com.example.testgraphql.modules.Author;
import com.example.testgraphql.modules.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	@Query("select author from Author author left join Book book on book.author.id = author.id")
	List<Author>findAuthorsWithBooks();

	List<Author>findByIdIn(List<Integer> authorIds);
}
