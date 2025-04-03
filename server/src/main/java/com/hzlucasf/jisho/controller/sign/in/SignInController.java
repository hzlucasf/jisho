package com.hzlucasf.jisho.controller.sign.in;

import com.hzlucasf.jisho.service.sign.in.SignInService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-in")
public class SignInController {
    private final SignInService service;

    public SignInController(SignInService service) {
        this.service = service;
    }
}
