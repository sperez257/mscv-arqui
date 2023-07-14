package com.example.serviceuser.controller;

import com.example.serviceuser.entity.User;
import com.example.serviceuser.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping("/users")
    @ResponseBody
    public User registerNewUser(@RequestBody User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        return userService.registerNewUser(user, getSiteURL(request));
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/users/admin")
    @ResponseBody
    public String forAdmin() {
        return "This URL is only accessible to the admin";
    }

    @GetMapping("/users/user")
    @ResponseBody
    public String forUser() {
        return "This URL is only accessible to the user";
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        User user = userService.findById(username);
        if(user != null){
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
        }
    }



}
