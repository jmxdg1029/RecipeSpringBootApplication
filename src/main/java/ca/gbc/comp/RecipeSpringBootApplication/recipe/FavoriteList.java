package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;

import javax.persistence.*;

@Entity(name="FavouriteList")
public class FavoriteList {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn
    private User user;
    private String recipeN;

    public FavoriteList(){
    }

    public FavoriteList(String recipeN, User user){
        this.recipeN = recipeN;
        this.user = user;
    }

    public int getId(){return id;}
    public void setId(Integer id){ this.id = id;}

    public String getName(){return recipeN;}
    public void setName(String recipeN){this.recipeN = recipeN;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

}
