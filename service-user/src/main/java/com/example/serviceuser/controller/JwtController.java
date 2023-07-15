package com.example.serviceuser.controller;

import com.example.serviceuser.dto.JwtRequest;
import com.example.serviceuser.dto.JwtResponse;
import com.example.serviceuser.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/jwt/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }

}
