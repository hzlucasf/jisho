package com.hzlucasf.jisho.controller.sign.up;

import com.hzlucasf.jisho.model.user.request.UserRequest;
import com.hzlucasf.jisho.model.user.response.UserResponse;
import com.hzlucasf.jisho.service.sign.up.SignUpService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {
    private final SignUpService service;

    public SignUpController(SignUpService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserResponse> signUp(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.signUp(userRequest));
    }
}
