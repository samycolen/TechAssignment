package com.example.PAF_TechAssignment.Controller;

import com.example.PAF_TechAssignment.Model.User;
import com.example.PAF_TechAssignment.Util.JwtUtils;
import com.example.PAF_TechAssignment.service.AuthService;
import com.example.PAF_TechAssignment.service.UserServiceDetails;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserServiceDetails userServiceDetails;

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;


    //requirement 2 : SignIn
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody User loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }


    // Requirement One
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        userServiceDetails.registerUser(signUpRequest.getEmail(), signUpRequest.getPassword());
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/test")
    public String test() {
        return "Service is working";
    }


    @GetMapping("/login")
    public String login() {
        return "Login"; // Return the name of the login view (login.html)
    }

 
}
























