package ca.gbc.comp.RecipeSpringBootApplication.mealplan;

import ca.gbc.comp.RecipeSpringBootApplication.recipe.Recipe;
import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealPlanRepository extends JpaRepository<MealPlan, Integer> {
    MealPlan findByUser(User user);
    MealPlan findByRecipe(Recipe recipe);
}
