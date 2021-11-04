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
    public String showLogin(@ModelAttribute("email") User user){
        return "index";
    }



    @RequestMapping(params = "submit", method = RequestMethod.POST)
    public String loginSubmission(@ModelAttribute("email") String em, @ModelAttribute("password") String psw, User user){
       if(userRepository.findByEmailAndPassword(em,psw) != null)
       {
           System.out.println(em);
           System.out.println(psw);
           System.out.println("it works");
           return "home";
       }
       else{
           System.out.println(em);
           System.out.println(psw);
           System.out.println("nope");
           return "index";
       }

    }

    @RequestMapping(params = "register", method = RequestMethod.POST)
    public String registrationForm(){
        return "redirect:/registration";
    }


}
