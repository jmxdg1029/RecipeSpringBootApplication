/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 12-05-2021
Description: This file is the setup for the event repository and calls from other repositories to be imported into the event plan database
 */

package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;

@Service
public class EventPlansService {
    private UserRepository userRepository;
    private MealPlanRepository mealPlanRepository;
    private EventPlansRepository eventPlansRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

    @Autowired
    public void setEventPlansRepository(EventPlansRepository eventPlansRepository){this.eventPlansRepository = eventPlansRepository;}

    public void registerEventPlan(String eventName, LocalDate date, Recipe mealOne,
                                  Recipe mealTwo, Recipe mealThree,Principal principal){
        EventPlans eventPlans = new EventPlans(eventName, date, mealOne,mealTwo,mealThree, userRepository.findByEmail(principal.getName()));
        eventPlansRepository.save(eventPlans);
    }
}
