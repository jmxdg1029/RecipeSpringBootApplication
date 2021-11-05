package ca.gbc.comp.RecipeSpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class registrationController implements WebMvcConfigurer {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/registration")
    public String showForm(@ModelAttribute("user") User user, Model model){
        User users = new User();
        model.addAttribute("user",users);
        return "registration";
    }

    @PostMapping("/registration")
    public String registeredForm(@ModelAttribute("user") User user){
        userRepository.save(user);
        System.out.println(user);
        return "registration";
    }




}
