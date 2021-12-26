package com.sip.Ams.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
     
 
    @Autowired
    private JwtRequestFilter jwtFilter;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	 
	  http.csrf().disable()
	  .authorizeRequests().antMatchers("/login","/api/users","/providers/**","/role/add").permitAll()
	  .anyRequest().authenticated().and().sessionManagement()
	  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	 

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
	return new BCryptPasswordEncoder();
    }

}
