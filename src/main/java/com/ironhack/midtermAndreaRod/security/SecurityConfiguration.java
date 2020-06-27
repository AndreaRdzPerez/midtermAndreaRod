package com.ironhack.midtermAndreaRod.security;

import com.ironhack.midtermAndreaRod.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
                .mvcMatchers("/loggedin").authenticated()
                .mvcMatchers(HttpMethod.GET, "/account/{id}").hasAnyAuthority("ROLE_ACCOUNTHOLDER")
                .mvcMatchers(HttpMethod.GET, "/account/debit/{id}/{amount}").hasAnyAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/account/credit/{id}/{amount}").hasAnyAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.POST, "/account/transference/{name}/{id}/{amount}").hasAnyAuthority("ROLE_ACCOUNTHOLDER")
                .mvcMatchers(HttpMethod.POST, "/savings/create").hasAnyAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/savings/balance/{id}").hasAnyAuthority("ROLE_ACCOUNTHOLDER")
                .mvcMatchers(HttpMethod.POST, "/creditcard/create").hasAnyAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/creditcard/balance/{id}").hasAnyAuthority("ROLE_ACCOUNTHOLDER")
                .mvcMatchers(HttpMethod.POST, "/checking/create").hasAnyAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.GET, "/checkings").hasAnyAuthority("ROLE_ACCOUNTHOLDER")
                .mvcMatchers(HttpMethod.GET, "/checking/balance/{id}").hasAnyAuthority("ROLE_ACCOUNTHOLDER")
                .anyRequest().permitAll();

    }
}