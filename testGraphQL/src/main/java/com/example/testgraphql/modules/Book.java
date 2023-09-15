package com.example.testgraphql.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "publication_year")
	private int publication_year;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	private Author author;


	@Override
	public String toString() {
		return "Book{" +
			"id=" + id +
			", title='" + title + '\'' +
			", publication_year=" + publication_year +
			", author=" + author +
			'}';
	}
}
