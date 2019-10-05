package com.linocks.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.linocks.graphql.model.Book;
import com.linocks.graphql.repository.BookRepository;
import com.linocks.graphql.resolver.Query;
import com.linocks.graphql.service.BookService;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class GraphqlApplication {

    @Autowired
    BookRepository bookRepository;
//
    @Autowired
    BookService bookService;
//
//    @Autowired
//    AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean graphQLBean(){
	    return new ServletRegistrationBean(SimpleGraphQLHttpServlet
                .newBuilder(buildSchema(bookService))
                .build(),"/graphql");
    }

	private static GraphQLSchema buildSchema(BookService bookService){
	    return SchemaParser.newParser()
                .file("books.graphql")
                .resolvers(new Query(bookService))
                .build()
                .makeExecutableSchema();
	}

	@Bean
    CommandLineRunner runner(){
		return args -> {
            bookRepository.saveAll(Arrays.asList(
               new Book("978-1-891830-75-4","110 Perc","tony Consiglio"),
               new Book("978-1-891830-56-3","Bighead","Jeffrey Brown"),
               new Book("978-1-891830-81-5","Cry Yourself to Sleep","Jeremy Tinder"),
               new Book("978-1-891830-17-4","Hutch Owen (Vol 2): Unmarketable","Tom Hart")
            )).stream().forEach(System.out::println);
		};
	}
}
