package ca.gbc.comp.RecipeSpringBootApplication;

public class User {
    private String firstname;
    private String lastname;
    private String password;
    private String email;

    public User(String firstname, String lastname, String password, String emial){
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = emial;
    }

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

    public void setPassword(){
        this.password = password;
    }
}
