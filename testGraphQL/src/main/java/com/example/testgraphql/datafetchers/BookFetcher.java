package com.example.testgraphql.datafetchers;

import com.example.testgraphql.modules.Book;
import com.example.testgraphql.repositories.BookRepository;
import com.example.testgraphql.services.BookService;
import com.example.testgraphql.services.serviceImp.BookServiceImp;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class BookFetcher {

	@Autowired
	private BookRepository bookRepository;

	@DgsQuery
	public Book findBookById(@InputArgument("id") int id){
		System.out.println("[call] findBookById(); id: "+id);
		return bookRepository.findById(id).orElseThrow( ()-> new NullPointerException());
	}

	@DgsQuery
	public List<Book> findAllBook(){
		System.out.println("[call] findAllBook()");
		return bookRepository.findAll();
	}

	@DgsMutation
	public Book addBook(@InputArgument String title, @InputArgument int publication_year){
		System.out.println("[call] addBook(); title: "+title+" publication_year: "+publication_year);
		Book book = new Book();
		book.setTitle(title);
		book.setPublication_year(publication_year);
		return bookRepository.save(book);
	}

	@DgsMutation
	public Book updateBook(@InputArgument int id, @InputArgument String title, int publication_year){
		System.out.println("[call] updateBook(); id: "+id+" title: "+title+" publication_year: "+publication_year);
		Book book = bookRepository.findById(id).orElseThrow( ()-> new NullPointerException());
		book.setPublication_year(publication_year);
		book.setTitle(title);
		return bookRepository.save(book);
	}


}
