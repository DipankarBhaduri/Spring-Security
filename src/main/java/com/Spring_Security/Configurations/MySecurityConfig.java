package com.Spring_Security.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity ( prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signin").permitAll()
                .antMatchers("/home" , "/login" , "/register").hasRole("NORMAL")  // or "/public/**" we can use ==>
                .antMatchers("/home/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/signin") ;
    }




//     This is WithOut Encoded password We are using for authentication  ==>

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Dipankar Bhaduri")
                .password("dipu1234")
                .roles("NORMAl") ;

        auth.inMemoryAuthentication()
                .withUser("Suvodeep Roy")
                .password("suvo1234")
                .roles("ADMIN") ;
    }


    @Bean
    public PasswordEncoder passwordEncoder (){
        return NoOpPasswordEncoder.getInstance() ;
    }

     */


    //     This is Encoded password We are using for authentication  ==>
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Dipankar Bhaduri")
                .password(this.passwordEncoder().encode("dipu1234"))
                .roles("NORMAl") ;

        auth.inMemoryAuthentication()
                .withUser("Suvodeep Roy")
                .password(this.passwordEncoder().encode("suvo1234"))
                .roles("ADMIN") ;
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder(16);
    }

}
