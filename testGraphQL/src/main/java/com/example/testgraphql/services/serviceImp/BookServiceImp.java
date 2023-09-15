package com.example.testgraphql.services.serviceImp;

import com.example.testgraphql.modules.Book;
import com.example.testgraphql.repositories.BookRepository;
import com.example.testgraphql.services.BookService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book getBookById(int id) {
		return bookRepository.findById(id).orElseThrow(() -> new NullPointerException());
	}

	@Override
	public Map<Integer, List<Book>> getBooksByAuthorIds(List<Integer> authorIDs) {
		return null;
	}

	@Override
	public Map<Integer, List<Book>> booksForAuthors(List<Integer> authorIDs) {
		return null;
	}


}
