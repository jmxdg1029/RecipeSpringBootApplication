/*
Project: Swagapino Recipe website
Assigment: 1
Authors: John-Michael De Guzman, Ruzzel Orejola, Gabriel Silva
Student Number: 101248,107, 101247477, 101245037
Date: 11-07-2021
Description: user repository has the findbyemail function to search for and compare other users
 */
package ca.gbc.comp.RecipeSpringBootApplication.user;

import ca.gbc.comp.RecipeSpringBootApplication.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword (String email, String password);
    User findByEmail(String email);
    User findByFirstname(String name);
}


