package ca.gbc.comp.RecipeSpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> { }

