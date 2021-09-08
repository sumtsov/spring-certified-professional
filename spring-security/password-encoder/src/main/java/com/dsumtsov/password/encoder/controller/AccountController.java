package com.dsumtsov.password.encoder.controller;

import com.dsumtsov.password.encoder.model.UserCredentials;
import com.dsumtsov.password.encoder.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.dsumtsov.password.encoder.security.constants.SecurityRoles.ROLE_PREFIX;
import static com.dsumtsov.password.encoder.security.constants.SecurityRoles.SUPER_ADMIN;
import static java.util.Collections.singletonList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/register")
public class AccountController {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public String register(@RequestBody @Valid UserCredentials userCredentials) {

        userDetailsManager.createUser(
                new User(
                        userCredentials.getUsername(),
                        passwordEncoder.encode(userCredentials.getPassword()),
                        singletonList(new SimpleGrantedAuthority(ROLE_PREFIX + SUPER_ADMIN))
                )
        );

        return "User " + userCredentials.getUsername() + " registered successfully.";
    }

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.addValidators(new UserValidator());
    }
}
