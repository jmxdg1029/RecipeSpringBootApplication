/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: This is the meal plan service, this allows to register a meal plan into the database
 */
package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;

@Service
public class MealPlanService {
    private UserRepository userRepository;
    private MealPlanRepository mealPlanRepository;
    private RecipeRepository recipeRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    public void setMealPlanRepository(MealPlanRepository mealPlanRepository){this.mealPlanRepository = mealPlanRepository;}

    public void registerMealPlan(LocalDate date, Recipe recipe, Principal principal){
        MealPlan mealPlan = new MealPlan(date, recipe, userRepository.findByEmail(principal.getName()));
        mealPlanRepository.save(mealPlan);
    }
}
