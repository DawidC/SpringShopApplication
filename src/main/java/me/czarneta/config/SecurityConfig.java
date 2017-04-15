package me.czarneta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Dawid on 15.04.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/style/**").permitAll()
                .antMatchers("/register", "/login", "/logout").permitAll()
                .antMatchers("/").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .and()
            .csrf()
                .disable();
    }


    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user@czarneta.me").password("pass").roles("USER");
    }
}
