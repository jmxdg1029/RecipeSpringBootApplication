/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: this is recipe service, this is used to register recipe and list recipes by name
 */
package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.List;

@Service
public class RecipeService {
    private UserRepository userRepository;
    private RecipeRepository recipeRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    public List<Recipe> listAll(String search) {
        return recipeRepository.findByKeyword(search);
    }
    public List<Recipe> listAllRecipe(String user){return recipeRepository.findByUser_Email(user);}

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository){this.recipeRepository = recipeRepository;}

    public void registerRec(String name, String desc, Principal principal) {
        Recipe recipe = new Recipe(name, desc, userRepository.findByEmail(principal.getName()));
        recipeRepository.save(recipe);
    }
}
