package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;

@Service
public class RecipeService {
    private UserRepository userRepository;
    private RecipeRepository recipeRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository){this.recipeRepository = recipeRepository;}

    public void registerRec(String name, String desc, Principal principal) {
        Recipe recipe = new Recipe(name, desc, userRepository.findByEmail(principal.getName()));
        recipeRepository.save(recipe);
    }
}
