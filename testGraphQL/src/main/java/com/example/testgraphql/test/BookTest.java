package com.example.testgraphql.test;

import com.example.testgraphql.datafetchers.BookFetcher;
import com.example.testgraphql.modules.Book;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {DgsAutoConfiguration.class, BookFetcher.class})
public class BookTest {
	@Autowired
	DgsQueryExecutor dgsQueryExecutor;

	@Test
	void getBook(){
		Book book = dgsQueryExecutor.executeAndExtractJsonPath(
			" { getBook { title publication_year }}",
			"data.title");

		assertThat(book.getTitle()).isEqualTo("chiu gor ho yeah");
	}
}
