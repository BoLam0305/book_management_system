package com.example.testgraphql.modules;

import java.util.Arrays;
import java.util.List;

public record Link (String id, String name, int pageCount, String authorId) {

	private static List<Link> books = Arrays.asList(
		new Link("book-1", "Effective Java", 416, "author-1"),
		new Link("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
		new Link("book-3", "Down Under", 436, "author-3")
	);

	public static Link getById(String id) {
		return books.stream()
			.filter(link -> link.id().equals(id))
			.findFirst()
			.orElse(null);
	}
}