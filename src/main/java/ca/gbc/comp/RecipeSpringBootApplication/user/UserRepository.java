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

