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
    public String showForm(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "index";
    }

    @PostMapping("/")
    public String index(@ModelAttribute("user") User user){
        userRepository.save(user);
        System.out.println(user);
        return "results";
    }


}
