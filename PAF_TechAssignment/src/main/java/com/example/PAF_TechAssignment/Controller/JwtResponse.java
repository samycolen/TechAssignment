
package com.example.PAF_TechAssignment.Controller;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    public JwtResponse(String jwt, String username, Collection<? extends GrantedAuthority> authorities) {
    }
}

