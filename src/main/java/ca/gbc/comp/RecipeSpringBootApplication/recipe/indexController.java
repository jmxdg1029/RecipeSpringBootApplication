/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: This is the index controller, it controls meal plan, list recipe, create recipe, and profile
 */


package ca.gbc.comp.RecipeSpringBootApplication.recipe;


import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

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

    @GetMapping("/viewRecipe")
    public String RecipeGet(Model model, Principal principal){
        model.addAttribute("recipes",recipeRepository.findByUser(userRepository.findByEmail(principal.getName())));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "viewRecipe";
    }

    @PostMapping("/viewRecipe")
    public String RecipePost(Model model, Principal principal){
        model.addAttribute("recipes",recipeRepository.findByUser(userRepository.findByEmail(principal.getName())));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "viewRecipe";
    }

    @GetMapping("/view-btn")
    public String IngGet(Model model,@RequestParam Integer id){
        model.addAttribute("recipes",recipeRepository.findRecipeById(id));
        return "viewIng";
    }



}
