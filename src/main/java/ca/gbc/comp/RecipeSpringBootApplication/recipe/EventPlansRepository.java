package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.recipe.MealPlan;
import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventPlansRepository extends JpaRepository<EventPlans, Integer> {
    EventPlans findByUser(User user);
    EventPlans findEventPlansById(Integer id);
    EventPlans findEventPlansByEventName(String eventName);
}
