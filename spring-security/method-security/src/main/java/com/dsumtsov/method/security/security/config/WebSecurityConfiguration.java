package com.dsumtsov.method.security.security.config;

import com.dsumtsov.method.security.security.config.entrypoint.CustomAuthenticationEntryPoint;
import com.dsumtsov.method.security.security.constants.SecurityRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("john")
                .password(passwordEncoder().encode("john"))
                .roles(SecurityRoles.SUPER_ADMIN)
                .and()
                .withUser("emma")
                .password(passwordEncoder().encode("emma"))
                .roles(SecurityRoles.EMPLOYEES_ADMIN)
                .and()
                .withUser("lucas")
                .password(passwordEncoder().encode("lucas"))
                .roles(SecurityRoles.CUSTOMERS_ADMIN)
                .and()
                .withUser("tom")
                .password(passwordEncoder().encode("tom"))
                .roles();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
