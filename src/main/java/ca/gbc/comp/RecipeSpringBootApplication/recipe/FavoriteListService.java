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
public class FavoriteListService {
    private UserRepository userRepository;
    private FavoriteListRepository favouriteListRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    public void setShoppingListRepository(FavoriteListRepository favouriteListRepository){this.favouriteListRepository = favouriteListRepository;}

    public List<FavoriteList> listAll(String user) {return favouriteListRepository.findByUser_Email(user);}

    public void registerFavouriteList(String ingredient, Principal principal){
        FavoriteList favouriteList = new FavoriteList(ingredient,userRepository.findByEmail(principal.getName()));
        favouriteListRepository.save(favouriteList);
    }
}