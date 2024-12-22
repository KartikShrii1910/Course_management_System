package com.coursemanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.coursemanagement.servicesImpl.CustomUserDetailServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailServiceImp customUserDetailServiceImp;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/signin", "/login/userdetails").permitAll()
                .antMatchers("/coursepurchase/{id}", "/coursepurchase", "/allpurchasecourses").hasRole("NORMAL")
                .antMatchers(
                        "/studentdetails/new",
                        "/studentdetails",
                        "/studentsdetails/edit/{id}",
                        "/course/new",
                        "/coursesdetails"
                ).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
//        .loginPage("/signin");
//       .defaultSuccessUrl("/check");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetailServiceImp).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
