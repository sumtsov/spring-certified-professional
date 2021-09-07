package com.dsumtsov.security.filter.chain.security.config;

import com.dsumtsov.security.filter.chain.security.config.entrypoint.CustomAuthenticationEntryPoint;
import com.dsumtsov.security.filter.chain.security.filter.CustomRequestParameterAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import static com.dsumtsov.security.filter.chain.security.constants.SecurityRoles.SUPER_ADMIN;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(new CustomRequestParameterAuthenticationFilter(), LogoutFilter.class)
                .authorizeRequests()
                .mvcMatchers("api/v1/customers").hasRole(SUPER_ADMIN)
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("john")
                .password(encoder().encode("john"))
                .roles(SUPER_ADMIN)
                .and()
                .withUser("tom")
                .password(encoder().encode("tom"))
                .roles();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
