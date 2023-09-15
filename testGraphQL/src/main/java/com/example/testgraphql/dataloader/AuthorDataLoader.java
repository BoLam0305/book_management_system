package com.example.testgraphql.dataloader;

import com.example.testgraphql.modules.Author;
import com.example.testgraphql.modules.Book;
import com.example.testgraphql.repositories.AuthorRepository;
import com.netflix.graphql.dgs.DgsDataLoader;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

@DgsDataLoader(name = "authorLoader")
public class AuthorDataLoader implements BatchLoader<Integer, Author> {
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public CompletionStage<List<Author>> load(List<Integer> list) {
		return CompletableFuture.supplyAsync(() -> authorRepository.findByIdIn(list));
	}
}
