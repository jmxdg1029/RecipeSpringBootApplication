package ca.gbc.comp.RecipeSpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class LoginController implements WebMvcConfigurer {

    @Autowired
    private UserRepository userRepository;




    @GetMapping("/")
    public String showLogin(@ModelAttribute("email") User user){
        return "login";
    }

    @RequestMapping(params = "submit", method = RequestMethod.POST)
    public String loginSubmission(@ModelAttribute("email") String em, @ModelAttribute("password") String psw, @ModelAttribute("loggedUser") User user)
            {
       if(userRepository.findByEmailAndPassword(em,psw) != null)
       {
           System.out.println(em);
           System.out.println(psw);
           System.out.println("it works");
           return "redirect:/home";
       }
       else{
           System.out.println(em);
           System.out.println(psw);
           System.out.println("nope");
           return "login";
       }

    }

    @RequestMapping(params = "register", method = RequestMethod.POST)
    public String registrationForm(){
        return "redirect:/registration";
    }


}
