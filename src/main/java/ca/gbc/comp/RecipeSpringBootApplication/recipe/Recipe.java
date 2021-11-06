package ca.gbc.comp.RecipeSpringBootApplication.recipe;


import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import javax.persistence.*;

@Entity(name="Recipe")
public class Recipe {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String ingredient;
    @ManyToOne
    @JoinColumn
    private User user;

    public Recipe(){
    }

    public Recipe(String name,String ingredient, User user){
        this.name = name;
        this.ingredient = ingredient;
        this.user = user;
    }

    public int getId(){return id;}
    public void setId(Integer id){ this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getIngredient(){return ingredient;}
    public void setIngredient(String ingredient){this.ingredient = ingredient;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}
}
