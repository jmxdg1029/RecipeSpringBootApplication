package ca.gbc.comp.RecipeSpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class indexController implements WebMvcConfigurer {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/home")
    public String showForm(Model model){
        return "index";
    }

    @RequestMapping(params = "logout", method = RequestMethod.POST)
    public String logoutButton(){
        return "redirect:/registration";
    }

}
