package com.community.community.controller;

import com.community.community.data.user.dto.SignInDto;
import com.community.community.data.user.dto.SignUpDto;
import com.community.community.data.user.model.User;
import com.community.community.service.sign.SignInService;
import com.community.community.service.sign.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody @Valid SignUpDto userDto) {
        return ResponseEntity.ok().body(signUpService.signUp(userDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody @Valid SignInDto userDto) {
        return ResponseEntity.ok().body(signInService.signIn(userDto));
    }
}
