package com.example.testgraphql.datafetchers;

import com.example.testgraphql.modules.Author;
import com.example.testgraphql.modules.Book;
import com.example.testgraphql.repositories.AuthorRepository;
import com.example.testgraphql.repositories.BookRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class BookFetchers {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;
//
//	@DgsData(parentType = "Author", field = "books")
//	public CompletableFuture<Book> book (DgsDataFetchingEnvironment dfe){
//		System.out.println("[book loader] call");
//		DataLoader<Integer, Book> dataLoader = dfe.getDataLoader("bookLoader");
//		Integer bookId = dfe.getArgument("id");
//		return dataLoader.load(bookId);
//	}

	@DgsMutation
	public Book createBook(String title, int publication_year, int authorId) {
		Author author = authorRepository.findById(authorId).orElse(null);
		if (author == null) {
			throw new IllegalArgumentException("Author not found with ID: " + authorId);
		}
		Book book = new Book();
		book.setTitle(title);
		book.setPublication_year(publication_year);
		book.setAuthor(author);
		return bookRepository.save(book);
	}

	@DgsQuery
	public List<Book> books () {
		List<Book> books = bookRepository.findAll();
		System.out.println(books.toString());
		return bookRepository.findAll();
	}

}
