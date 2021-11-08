/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: registration controller is the controller for the registration page
 */
package ca.gbc.comp.RecipeSpringBootApplication.user;


import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

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
    public String registeredForm(@ModelAttribute("user") User user, @RequestParam String email){

        if (user.getEmail().length() > 0 && !user.getEmail().contains("@")) {
            if(user.getFirstname().length() > 0 && user.getLastname().length() > 0 && user.getPassword().length() > 0) {
                System.out.println("Try Again!");
                return "registration";
            }
            System.out.println("Try Again!");
            return "registration";
        }
        else if (user.getEmail().equals(null) || user.getEmail().equals("")){
            return "redirect:login";
        }
        else {
            userRepository.save(user);
            System.out.println(user);
            return "redirect:login";
        }
    }
}
