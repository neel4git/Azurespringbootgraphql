package com.graphql.azurefunctionsspringbootgrapqlexample;

import com.graphql.azurefunctionsspringbootgrapqlexample.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringBootGrapqlExampleApplication {

	@Autowired
	GraphQLService graphQLService;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootGrapqlExampleApplication.class, args);
	}
	@Bean
	public Function<String, ExecutionResult> ContentHandler() {
		return input -> graphQLService.getGraphQL().execute(input);
	}
}
