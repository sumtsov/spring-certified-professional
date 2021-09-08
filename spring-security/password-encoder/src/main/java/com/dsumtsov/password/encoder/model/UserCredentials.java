package com.dsumtsov.password.encoder.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserCredentials {
    @NotBlank(message = "Username cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Username contains illegal characters")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Password contains illegal characters")
    private String password;
    @NotBlank(message = "Repeated password cannot be empty")
    @Pattern(regexp = "[A-Za-z0-9]*", message = "Repeated password contains illegal characters")
    private String repeatedPassword;
}
