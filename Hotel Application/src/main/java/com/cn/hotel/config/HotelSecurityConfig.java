package com.cn.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//For the explanation of the methods
/*https://chatgpt.com/share/670a3a19-d050-8009-8ed6-aeaaba487ddc*/
public class HotelSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //This is use for the goggle chrome to see in the web page
        //(In the last we have to add the formLogin)
      /*  httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest().authenticated().and().formLogin();*/

/**********************************************************************************************/
        //This is for the postman

        //If i want to allow all the operation is used by the admin then do /hotel/**
        //(**)
        /*httpSecurity.csrf().disable()
                .authorizeHttpRequests().antMatchers("/hotel/create").hasRole("ADMIN")
                .anyRequest().authenticated().and().httpBasic();*/

/**************************************************************************************************/
        //For the Method Level Security
        //We add the @EnableGlobalMethodSecurity (in this method)
        //add the @preauthorize in the controller
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest().authenticated().and().httpBasic();
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user1 = User.builder().
                username("Aditya").
                password(passwordEncoder().encode("Adi"))
                .roles("USER")
                .build();

        UserDetails user2 = User.builder().
                username("Shivam").
                password(passwordEncoder().encode("Shi"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
