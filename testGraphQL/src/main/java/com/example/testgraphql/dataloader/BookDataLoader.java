package com.example.testgraphql.dataloader;

import com.example.testgraphql.modules.Book;
import com.example.testgraphql.repositories.BookRepository;
import com.netflix.graphql.dgs.DgsDataLoader;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

@DgsDataLoader(name = "bookLoader")
public class BookDataLoader implements BatchLoader<Integer, Book> {

	@Autowired
	BookRepository bookRepository;

	@Override
	public CompletionStage<List<Book>> load(List<Integer> keys) {
		CompletionStage<List<Book>> s = CompletableFuture.supplyAsync(() -> bookRepository.findByIdIn(
			Collections.singletonList(1)));
		return CompletableFuture.supplyAsync(() -> bookRepository.findByIdIn(keys));
	}
}
