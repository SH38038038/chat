package com.sj.chat.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sj.chat.user.dto.UserSignupRequest;
import com.sj.chat.user.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> signUp(@Valid @RequestBody UserSignupRequest requestBody){
        userService.signup(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
