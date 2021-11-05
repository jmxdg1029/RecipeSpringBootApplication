package ca.gbc.comp.RecipeSpringBootApplication;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

public class MvcConfig {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
    }
}
