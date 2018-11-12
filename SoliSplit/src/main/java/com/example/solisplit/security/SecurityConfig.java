package com.example.solisplit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
  @Autowired
  private PasswordEncoder passwordEncoder;
	
  @Bean
  public PasswordEncoder passwordEncoder () {
	  return new BCryptPasswordEncoder();
  }
  @Autowired
  private UserDetailsServiceImpl userDetailsService;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.userDetailsService(userDetailsService)
    	.passwordEncoder(passwordEncoder);
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.csrf().disable()
        .authorizeRequests()
          .antMatchers("/js/*","/css/*").permitAll()
          .antMatchers("/register").permitAll()
//          .antMatchers("/admin/**").hasRole("ADMIN") // commented out on purpose, just for learning purposes
          .antMatchers("/**").hasRole("USER").and()
        .formLogin()
          .loginPage("/login")
          .defaultSuccessUrl("/groups")
          .permitAll().and()
        .logout()
          .logoutSuccessUrl("/")
          .permitAll();
        
  }
}
