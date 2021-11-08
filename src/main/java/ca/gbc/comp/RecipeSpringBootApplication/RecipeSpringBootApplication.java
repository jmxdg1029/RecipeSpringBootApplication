/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: runs the app
 */
package ca.gbc.comp.RecipeSpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class RecipeSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSpringBootApplication.class, args);
	}

}
