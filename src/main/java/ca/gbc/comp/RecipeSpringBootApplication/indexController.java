package ca.gbc.comp.RecipeSpringBootApplication;





import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class indexController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String index(@ModelAttribute("user") User user){
        return "index";
    }


}
