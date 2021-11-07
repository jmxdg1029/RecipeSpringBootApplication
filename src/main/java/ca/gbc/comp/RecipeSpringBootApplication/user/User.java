package ca.gbc.comp.RecipeSpringBootApplication.user;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;

    public User(){}

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = "{noop}" + password;
    }


}