package com.alumnione.ecommerce.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid UserDataAuthenticationDTO userDataAuthenticationDTO) {
        Authentication authtoken = new UsernamePasswordAuthenticationToken(userDataAuthenticationDTO.user(), userDataAuthenticationDTO.password());
        Authentication userAuthenticated = authenticationManager.authenticate(authtoken);
        String JWTtoken = tokenService.generateToken((User)userAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DataJWTtoken(JWTtoken));
    }
}