package ca.gbc.comp.RecipeSpringBootApplication.recipe;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name="eventPlan")
public class EventPlans {
    @Id
    @GeneratedValue
    private int id;
    private String eventName;
    @DateTimeFormat (pattern="YYYY-MM-DD")
    private LocalDate date;
    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private Recipe mealOne;
    @ManyToOne
    @JoinColumn
    private Recipe mealTwo;
    @ManyToOne
    @JoinColumn
    private Recipe mealThree;

    public EventPlans(String eventName, LocalDate date, Recipe mealOne
            ,Recipe mealTwo, Recipe mealThree, User user)
    {
        this.eventName = eventName;
        this.date = date;
        this.mealOne = mealOne;
        this.mealTwo = mealTwo;
        this.mealThree = mealThree;
        this.user = user;
    }

    public EventPlans() {

    }

    public int getId(){return id;}
    public void setId(Integer id){ this.id = id;}

    public LocalDate getDate(){return date;}
    public void setDate(LocalDate date){this.date = date;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    public Recipe getMealOne() {
        return mealOne;
    }
    public void setMealOne(Recipe mealOne) {
        this.mealOne = mealOne;
    }

    public Recipe getMealTwo() {
        return mealTwo;
    }
    public void setMealTwo(Recipe mealTwo) {
        this.mealTwo = mealTwo;
    }

    public Recipe getMealThree() {
        return mealThree;
    }
    public void setMealThree(Recipe mealThree) {
        this.mealThree = mealThree;
    }

    public String getEventName() {return eventName;}

    public void setEventName(String eventName) {this.eventName = eventName;}
}

