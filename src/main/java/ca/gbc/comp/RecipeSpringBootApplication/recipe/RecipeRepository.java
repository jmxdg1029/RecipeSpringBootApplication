package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Recipe findByUser(User user);
<<<<<<< HEAD

    @Query(value="select r from Recipe r where r.name like %:search%")
    List<Recipe> findByKeyword(String search);

=======
    Recipe findByName(String name);
>>>>>>> mealplandropmenu
}
