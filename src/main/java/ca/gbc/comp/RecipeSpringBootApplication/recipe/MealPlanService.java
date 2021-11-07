package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;

@Service
public class MealPlanService {
    private UserRepository userRepository;
    private MealPlanRepository mealPlanRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    public void setMealPlanRepository(MealPlanRepository mealPlanRepository){this.mealPlanRepository = mealPlanRepository;}

    public void registerMealPlan(String breakfast,
                                 String snackOne,
                                 String lunch,
                                 String snackTwo,
                                 String dinner,
                                 String snackThree,
                                 Principal principal){
        MealPlan mealPlan = new MealPlan(breakfast,
                snackOne,
                lunch,
                snackTwo,
                dinner,
                snackThree,
                userRepository.findByEmail(principal.getName()));
                mealPlanRepository.save(mealPlan);
    }
}
