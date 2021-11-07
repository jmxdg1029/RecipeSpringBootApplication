package ca.gbc.comp.RecipeSpringBootApplication.mealplan;

import ca.gbc.comp.RecipeSpringBootApplication.recipe.Recipe;
import ca.gbc.comp.RecipeSpringBootApplication.user.User;

import javax.persistence.*;

@Entity(name="MealPlan")
public class MealPlan {
    @Id
    @GeneratedValue
    private int id;
    private String breakfast;
    private String snackOne;
    private String lunch;
    private String snackTwo;
    private String dinner;
    private String snackThree;
    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private Recipe recipe;

    public MealPlan(){
    }

    public MealPlan(  String breakfast,
                      String snackOne,
                      String lunch,
                      String snackTwo,
                      String dinner,
                      String snackThree,
                      User user
    ) {
        this.breakfast = breakfast;
        this.snackOne = snackOne;
        this.lunch = lunch;
        this.snackTwo = snackTwo;
        this.dinner = dinner;
        this.snackThree = snackThree;
        this.user = user;
    }

    public int getId(){return id;}
    public void setId(Integer id){ this.id = id;}

    public String getBreakfast() {
        return breakfast;
    }
    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getGetSnackOne() {
        return snackOne;
    }
    public void setSnackOne(String snackOne) {
        this.snackOne = snackOne;
    }

    public String getLunch() {
        return lunch;
    }
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getSnackTwo() {
        return snackTwo;
    }
    public void setSnackTwo(String snackTwo) {
        this.snackTwo = snackTwo;
    }

    public String getDinner() {
        return dinner;
    }
    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSnackThree() {
        return snackThree;
    }
    public void setSnackThree(String snackThree) {
        this.snackThree = snackThree;
    }

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

