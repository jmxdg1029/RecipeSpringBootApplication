/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: This is the index controller, it controls meal plan, list recipe, create recipe, and profile
 */


package ca.gbc.comp.RecipeSpringBootApplication.recipe;


import ca.gbc.comp.RecipeSpringBootApplication.user.CustomUserDetailsService;
import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Principal;
import java.time.LocalDate;

@Controller
public class indexController implements WebMvcConfigurer {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    MealPlanService mealPlanService;

    @Autowired
    MealPlanRepository mealPlanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ShoppingListRepository shoppingListRepository;

    @Autowired
    ShoppingListService shoppingListService;

    @Autowired
    FavoriteListRepository favoriteListRepository;

    @Autowired
    FavoriteListService favoriteListService;

    @GetMapping("/home")
    public String showForm(){
        return "index";
    }

    @GetMapping(value = "/create")
    public String createButton()
    {
        return "addRecipe";
    }

    @GetMapping(value = "/createMealPlan")
    public String createMealPlanButton(Model model)
    {
        model.addAttribute("recipes",recipeRepository.findAll());
        System.out.println(recipeRepository.findAll());
        return "addMealPlan";
    }


    @GetMapping(value = "/registRec")
    public String submitRec(@RequestParam String name, @RequestParam String desc, Principal principal){
        recipeService.registerRec(name,desc,principal);
        return "index";
    }

    @GetMapping(value = "/registerMealPlan")
    public String submitMealPlanGet(@RequestParam("date")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                    @RequestParam Recipe recipe,
                                    Principal principal){
        mealPlanService.registerMealPlan(date,recipe,principal);
        System.out.println(date);
        System.out.println(recipe);
        return "index";
    }

    @GetMapping("/listMealPlan")
    public String listMealPlanGet(Model model){
        model.addAttribute("mealPlans",mealPlanRepository.findAll());
        return "listMealPlan";
    }

    @PostMapping("/listMealPlan")
    public String listMealPlanPost(Model model){
        model.addAttribute("mealPlans",mealPlanRepository.findAll());
        return "listMealPlan";
    }

    @GetMapping("/list")
    public String listRecipeGet(Model model){
        model.addAttribute("recipes",recipeRepository.findAll());
        return "recipeList";
    }

    @PostMapping("/list")
    public String listRecipePost(Model model, @RequestParam String search){
        if(search != null) {
            model.addAttribute("recipes", recipeService.listAll(search));
        }
        else {
            model.addAttribute("recipes", recipeRepository.findAll());
        }
        return "recipeList";
    }


    @GetMapping("/profile")
    public String profileGet(Model model, Principal principal){
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "profile";
    }

    @PostMapping("/profile")
    public String profilePost(Model model, Principal principal){
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "profile";
    }

    @GetMapping(value = "/editProfile")
    public String editProfile(Model model, Principal principal){
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "editProfile";
    }



    @GetMapping("/registerEditedProfile")
    public String updateUser(User user, Principal principal, Model model,@RequestParam String email,@RequestParam String password) {
        User currUser = userRepository.findByEmail(principal.getName());
        System.out.println(currUser);
        System.out.println(currUser.getEmail());
        System.out.println(currUser.getPassword());
        currUser.setEmail(email);
        userRepository.save(currUser);
        currUser.setPassword(password);
        userRepository.save(currUser);
        return "login";
    }


    @GetMapping("/viewRecipe")
    public String RecipeGet(Model model, Principal principal){
        model.addAttribute("recipes",recipeService.listAllRecipe(principal.getName()));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "viewRecipe";
    }

    @PostMapping("/viewRecipe")
    public String RecipePost(Model model, Principal principal){
        model.addAttribute("recipes",recipeService.listAllRecipe(principal.getName()));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "viewRecipe";
    }

    @GetMapping("/view-btn")
    public String IngSGet(Model model,@RequestParam Integer id){
        model.addAttribute("recipes",recipeRepository.findRecipeById(id));
        return "viewIng";
    }

    @GetMapping("/fav-btn")
    public String IngFGet(Model model,@RequestParam Integer id){
        model.addAttribute("recipes",recipeRepository.findRecipeById(id));
        return "viewFav";
    }

    @GetMapping("/add-shop")
    public String ShoppingGet(Model model, @RequestParam String ing, Principal principal){
        shoppingListService.registerShoppingList(ing,principal);
        return "index";
    }

    @GetMapping("/add-fav")
    public String FavGet(Model model, @RequestParam String ing, Principal principal){
        favoriteListService.registerFavouriteList(ing,principal);
        return "index";
    }

    @GetMapping("/shoppingList")
    public String shopGet(Model model, Principal principal){
        model.addAttribute("shopping",shoppingListService.listAll(principal.getName()));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "shoppingList";
    }

    @PostMapping("/shoppingList")
    public String shopPost(Model model, Principal principal){
        model.addAttribute("shopping",shoppingListService.listAll(principal.getName()));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "shoppingList";
    }

    @GetMapping("/favoriteList")
    public String favGet(Model model, Principal principal){
        model.addAttribute("favorite",favoriteListService.listAll(principal.getName()));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "favoriteList";
    }

    @PostMapping("/favoriteList")
    public String favPost(Model model, Principal principal){
        model.addAttribute("favorite",favoriteListService.listAll(principal.getName()));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "favoriteList";
    }
}
