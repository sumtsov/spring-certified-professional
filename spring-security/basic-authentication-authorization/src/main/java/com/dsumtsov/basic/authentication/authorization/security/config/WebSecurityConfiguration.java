package com.dsumtsov.basic.authentication.authorization.security.config;

import com.dsumtsov.basic.authentication.authorization.security.config.entrypoint.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import static com.dsumtsov.basic.authentication.authorization.security.constants.SecurityRoles.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationEntryPoint authenticationEntryPoint;
    private final RoleHierarchy roleHierarchy;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .expressionHandler(expressionHandler())
                .mvcMatchers("api/v1/customers").hasRole(CUSTOMERS_PAG_VIEW)
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("john")
                .password(encoder().encode("john"))
                .roles(SUPER_ADMIN)
                .and()
                .withUser("lucas")
                .password(encoder().encode("lucas"))
                .roles(CUSTOMERS_PAG_VIEW, CUSTOMERS_READ)
                .and()
                .withUser("tom")
                .password(encoder().encode("tom"))
                .roles();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    private DefaultWebSecurityExpressionHandler expressionHandler() {
        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
        expressionHandler.setRoleHierarchy(roleHierarchy);
        return expressionHandler;
    }
}
