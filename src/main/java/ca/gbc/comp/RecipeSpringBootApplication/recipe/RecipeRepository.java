package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Recipe findByUser(User user);
}
