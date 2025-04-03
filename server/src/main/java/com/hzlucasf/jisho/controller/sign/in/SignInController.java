package com.hzlucasf.jisho.controller.sign.in;

import com.hzlucasf.jisho.model.jwt.response.JwtResponse;
import com.hzlucasf.jisho.service.sign.in.SignInService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-in")
public class SignInController {
    private final SignInService service;

    public SignInController(SignInService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JwtResponse> signIn(Authentication authentication) {
        return ResponseEntity.status(HttpStatus.OK).body(service.signIn(authentication));
    }
}
