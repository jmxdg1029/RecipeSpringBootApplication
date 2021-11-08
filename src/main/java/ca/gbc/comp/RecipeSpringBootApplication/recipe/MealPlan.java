/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: This is the meal plan object and what is used to create the meal plan table
 */

package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name="MealPlan")
public class MealPlan {
    @Id
    @GeneratedValue
    private int id;
    @DateTimeFormat (pattern="YYYY-MM-DD")
    private LocalDate date;
    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private Recipe recipe;

    public MealPlan(){
    }

    public MealPlan(LocalDate date, Recipe recipe, User user)
    {
        this.date = date;
        this.recipe = recipe;
        this.user = user;
    }

    public int getId(){return id;}
    public void setId(Integer id){ this.id = id;}

    public LocalDate getDate(){return date;}
    public void setDate(LocalDate date){this.date = date;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

