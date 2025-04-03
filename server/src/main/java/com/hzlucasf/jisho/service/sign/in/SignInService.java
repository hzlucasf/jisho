package com.hzlucasf.jisho.service.sign.in;

import com.hzlucasf.jisho.service.jwt.JwtService;
import org.springframework.stereotype.Service;

@Service
public class SignInService {
    private final JwtService jwtService;

    public SignInService(JwtService jwtService) {
        this.jwtService = jwtService;
    }
}
