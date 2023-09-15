package com.example.testgraphql.services;

import com.example.testgraphql.modules.Book;
import java.util.List;
import java.util.Map;

public interface BookService {
	Book getBookById(int id);

	Map<Integer, List<Book>> getBooksByAuthorIds(List<Integer>authorIDs);

	Map<Integer, List<Book>> booksForAuthors(List<Integer> authorIDs);
}
