package ca.gbc.comp.RecipeSpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class RecipeSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSpringBootApplication.class, args);
	}


	//JM is cute, sometimes
	//Ruzzel is cute, always
}
