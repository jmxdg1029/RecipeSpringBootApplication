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