/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: This is the recipe repository, this is used to find the user by id and help to list all recipes by a certain name
 */
package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Recipe findByUser(User user);
    @Query(value="select r from Recipe r where r.name like %:search%")
    List<Recipe> findByKeyword(String search);

   Recipe findRecipeById(Integer id);
   Recipe findRecipeByIngredient(String ingredient);
   Recipe findByName(String name);
   Recipe findAllByUser(User user);
   List<Recipe> findByUser_Email(String user);

}
