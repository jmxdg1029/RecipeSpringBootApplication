package ca.gbc.comp.RecipeSpringBootApplication.recipe;


import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Principal;

@Controller
public class indexController implements WebMvcConfigurer {

    @Autowired
    RecipeService recipeService;

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

    @GetMapping(value = "/registRec")
    public String submitRec(@RequestParam String name, @RequestParam String desc, Principal principal){


        recipeService.registerRec(name,desc,principal);
        return "index";
    }


}
