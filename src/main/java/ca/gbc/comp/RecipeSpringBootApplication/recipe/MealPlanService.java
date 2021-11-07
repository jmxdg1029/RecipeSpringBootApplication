package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;
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

    public void registerMealPlan(Date date, Recipe recipe, Principal principal){
        MealPlan mealPlan = new MealPlan(date, recipeRepository.findByName(recipe.getName()), userRepository.findByEmail(principal.getName()));
                mealPlanRepository.save(mealPlan);
    }
}
