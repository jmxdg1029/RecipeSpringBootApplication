package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.recipe.Recipe;
import ca.gbc.comp.RecipeSpringBootApplication.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity(name="MealPlan")
public class MealPlan {
    @Id
    @GeneratedValue
    private int id;
    private Date date;
    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private Recipe recipe;

    public MealPlan(){
    }

    public MealPlan(Date date, Recipe recipe, User user)
    {
        this.date = date;
        this.recipe = recipe;
        this.user = user;
    }

    public int getId(){return id;}
    public void setId(Integer id){ this.id = id;}

    public Date getDate(){return date;}
    public void setDate(Date date){this.date = date;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

