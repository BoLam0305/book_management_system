package com.example.testgraphql.services.serviceImp;

import com.example.testgraphql.modules.Author;
import com.example.testgraphql.modules.AuthorInput;
import com.example.testgraphql.modules.Book;
import com.example.testgraphql.modules.BookInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
