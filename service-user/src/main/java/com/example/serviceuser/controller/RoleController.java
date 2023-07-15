package com.example.serviceuser.controller;

import com.example.serviceuser.entity.Role;
import com.example.serviceuser.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/roles")
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }

}