package ca.gbc.comp.RecipeSpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class LoginController implements WebMvcConfigurer {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public String showLogin(@ModelAttribute("email") User user){
        return "login";
    }

    @PostMapping("/login")
    public String PassingNotesListPost(){
        return "login";
    }




}
