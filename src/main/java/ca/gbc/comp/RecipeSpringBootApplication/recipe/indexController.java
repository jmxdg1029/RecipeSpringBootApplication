package ca.gbc.comp.RecipeSpringBootApplication.recipe;


import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Principal;
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
    public String createMealPlanButton()
    {
        return "addMealPlan";
    }


    @GetMapping(value = "/registRec")
    public String submitRec(@RequestParam String name, @RequestParam String desc, Principal principal){
        recipeService.registerRec(name,desc,principal);
        return "index";
    }

    @GetMapping(value = "/registerMealPlan")
    public String submitMealPLanGet(Date date, Recipe recipe, Principal principal, Model model){
        model.addAttribute("recipes",recipeRepository.findAll());
        mealPlanService.registerMealPlan(date,recipe,principal);
        return "addMealPlan";
    }

    @PostMapping(value = "/registerMealPlan")
    public String submitMealPLanPost(Date date, Recipe recipe, Principal principal, Model model){
        model.addAttribute("recipes",recipeRepository.findAll());
        mealPlanService.registerMealPlan(date,recipe,principal);
        return "listMealPlan";
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
        model.addAttribute("recipes",recipeRepository.findByUser(userRepository.findByEmail(principal.getName())));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "profile";
    }

    @PostMapping("/profile")
    public String profilePost(Model model, Principal principal){
        model.addAttribute("recipes",recipeRepository.findByUser(userRepository.findByEmail(principal.getName())));
        model.addAttribute("users",userRepository.findByEmail(principal.getName()));
        return "profile";
    }

}
