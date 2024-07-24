package com.example.PAF_TechAssignment.Controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignUpRequest {
    @NotBlank
    @Email
    @Size(max=40)
    private String email;

    @NotBlank
    @Size(min=6,max=100)
    private String password;

    public @NotBlank @Email @Size(max = 40) String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email @Size(max = 40) String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 6, max = 100) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 6, max = 100) String password) {
        this.password = password;
    }
}
