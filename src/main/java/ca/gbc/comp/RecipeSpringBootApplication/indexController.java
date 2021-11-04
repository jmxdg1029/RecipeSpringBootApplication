package ca.gbc.comp.RecipeSpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class indexController implements WebMvcConfigurer {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String loginForm(){
        return "index";
    }

    @RequestMapping(params = "submit", method = RequestMethod.POST)
    public String loginSubmission(){
        return "home";
    }

    @RequestMapping(params = "register", method = RequestMethod.POST)
    public String registrationForm(){
        return "redirect:/registration";
    }


}
