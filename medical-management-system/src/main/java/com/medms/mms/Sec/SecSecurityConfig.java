package com.medms.mms.Sec;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager (see below)
    	
    	auth.inMemoryAuthentication()
    	.withUser("staff")
    	.password("staff")
    	.roles("USER")
    	.and()
    	.withUser("admin")
    	.password("admin")
    	.roles("ADMIN");
    	
    }
    
    @Bean 
    public PasswordEncoder getPasswordEncoder() { 
        return NoOpPasswordEncoder.getInstance(); 
    }
    
    

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
     	// http builder configurations for authorize requests and form login (see below)
    	http.authorizeRequests()
    	.antMatchers("/admin").hasRole("ADMIN")
    	.antMatchers("/user").hasRole("USER")
    	.antMatchers("/").permitAll()
    	.and().formLogin();
    
    
    
    }
    
    
}