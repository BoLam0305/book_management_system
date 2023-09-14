package com.example.testgraphql.datafetchers;

import com.example.testgraphql.modules.Author;
import com.example.testgraphql.modules.AuthorInput;
import com.example.testgraphql.repositories.AuthorRepository;
import com.example.testgraphql.services.serviceImp.AuthorServiceImp;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class AuthorFetcher {
	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	AuthorServiceImp authorService;

	@DgsQuery
	public Author findAuthor(@InputArgument int id){
		System.out.println("[call] findAuthor(); id: "+id);
		return authorRepository.findById(id).orElseThrow( ()-> new NullPointerException());
	}
	@DgsQuery
	public List<Author> findAllAuthor(){
		System.out.println("[call] findAllAuthor();");
		return authorRepository.findAll();
	}
	@DgsMutation
	public Author addAuthor(@InputArgument String name){
		System.out.println("[call] addAuthor(); name: "+name);
		Author author = new Author();
		author.setName(name);
		return authorRepository.save(author);
	}

	@DgsMutation
	public Author addAuthorWithBooks( @InputArgument(value = "authorInput") Map<String, Object> obj){
		System.out.println("[call] addAuthor(); books: "+obj.toString()+" class type: "+obj.getClass());
		Author author = authorService.convertToAuthorInput(obj);
		return authorRepository.save(author);
	}

}
