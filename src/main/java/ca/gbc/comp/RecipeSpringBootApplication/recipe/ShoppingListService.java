package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.security.Principal;

@Service
public class ShoppingListService {
    private UserRepository userRepository;
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    public void setShoppingListRepository(ShoppingListRepository shoppingListRepository){this.shoppingListRepository = shoppingListRepository;}

    public List<ShoppingList> listAll(String user) {return shoppingListRepository.findByUser_Email(user);}

    public void registerShoppingList(String ingredient, Principal principal){
        ShoppingList shoppingList = new ShoppingList(ingredient,userRepository.findByEmail(principal.getName()));
        shoppingListRepository.save(shoppingList);
    }

}
