package com.community.community.controller;

import com.community.community.data.domain.SignInDto;
import com.community.community.data.domain.SignUpDto;
import com.community.community.service.SignInService;
import com.community.community.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDto userDto) {
        return ResponseEntity.ok().body(signUpService.signUp(userDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInDto userDto) {
        return ResponseEntity.ok().body(signInService.signIn(userDto));
    }
}
