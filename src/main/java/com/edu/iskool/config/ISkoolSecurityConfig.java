package com.edu.iskool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ISkoolSecurityConfig extends WebSecurityConfigurerAdapter  {

	 // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	

        auth.inMemoryAuthentication()
                .withUser("testUser").password("{noop}test123").roles("USER")
                .and()
                .withUser("testAdmin").password("{noop}test1234").roles("USER", "ADMIN");

    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/iskool/**").hasRole("USER")
                 .antMatchers(HttpMethod.POST, "/iskool").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/iskool/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/iskool/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/iskool/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
