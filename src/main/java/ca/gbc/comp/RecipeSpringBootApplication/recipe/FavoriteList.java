/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 12-05-2021
Description: This java file is responsible for the framework of the favorite list database and initializes all the getters and setters
 */

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
