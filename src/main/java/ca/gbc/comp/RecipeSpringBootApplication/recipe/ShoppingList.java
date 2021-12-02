package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;

import javax.persistence.*;

@Entity(name="ShoppingList")
public class ShoppingList {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn
    private User user;


}
