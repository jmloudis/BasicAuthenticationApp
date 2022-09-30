package com.testing.newspringsecurityproject.controller;

import com.testing.newspringsecurityproject.model.User;
import com.testing.newspringsecurityproject.model.UserPrincipal;
import com.testing.newspringsecurityproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class AuthController
{

    private UserRepo userRepository;

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserRepo userRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/home")
    public String showUser()
    {
        return "Application Works";
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        authenticate(user.getUsername(), user.getPassword());
        User loginUser = userRepository.findUserByUsername(user.getUsername());
        return new ResponseEntity<>(loginUser, OK);
    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }
}
