package com.example.testgraphql.services;

import com.example.testgraphql.modules.Book;
import java.util.List;

public interface BookService {
	Book getBookById(int id);

	List<Book>getBooksByAuthorIds(List<Integer>authorIDs);
}
