package com.hzlucasf.jisho.controller.sign.up;

import com.hzlucasf.jisho.service.sign.up.SignUpService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {
    private final SignUpService service;

    public SignUpController(SignUpService service) {
        this.service = service;
    }
}
