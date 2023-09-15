package com.example.testgraphql.datafetchers;

import com.example.testgraphql.dataloader.AuthorDataLoader;
import com.example.testgraphql.modules.Author;
import com.example.testgraphql.repositories.AuthorRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;

import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class AuthorFetchers {
	@Autowired
	private AuthorRepository authorRepository;

	@DgsQuery
	public List<Author> authors() {
		return authorRepository.findAll();
	}

	@DgsQuery
	public List<Author>getAuthorsWithBooks(){
		return authorRepository.findAuthorsWithBooks();
	}

	@DgsData(parentType = "Book", field = "author")
	public CompletableFuture<Author> author (DataFetchingEnvironment dfe){
		DataLoader<String, Author> dataLoader = dfe.getDataLoader("authorLoader");
		String id = dfe.getArgument("directorId");
		return dataLoader.load(id);
	}

	@DgsMutation
	public Author createAuthor(String name){
		Author author = new Author();
		author.setName(name);
		return authorRepository.save(author);
	}

	@DgsMutation
	public Author updateAuthor(int id, String name) {
		Author author = authorRepository.findById(id).orElse(null);
		if (author == null) {
			throw new IllegalArgumentException("Author not found with ID: " + id);
		}
		author.setName(name);
		return authorRepository.save(author);
	}

	@DgsMutation
	public int deleteAuthor(int id) {
		authorRepository.deleteById(id);
		return id;
	}


}
