/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 12-05-2021
Description: This files is responsible for adding values into the repository and imports user repository
 */

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
