package com.example.testgraphql.services.serviceImp;

import com.example.testgraphql.modules.Author;
import com.example.testgraphql.modules.Book;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImp {
	public Author convertToAuthorInput(Map<String, Object> obj){
		return null;
	}

	public Map<Integer, List<Book>> booksForAuthor(List<Integer> authorIds) {
		return null;
	}
}
