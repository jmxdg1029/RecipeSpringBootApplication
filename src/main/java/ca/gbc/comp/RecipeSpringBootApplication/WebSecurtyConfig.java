package ca.gbc.comp.RecipeSpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurtyConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/registration","/h2-console/**").permitAll() //delete h2. for h2database access during development
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll().and().exceptionHandling().accessDeniedPage("/error");

        http.csrf().disable(); //delete this. for h2database access during development
        http.headers().frameOptions().disable(); //delete this. for h2database access during development
        http.formLogin().defaultSuccessUrl("/home");
        System.out.println();
    }

    //allowing access to the website resource files(bootstrap, css etc.).
    //todo change h2-console
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/webjars/**");
    }
}
