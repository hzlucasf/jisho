package com.hzlucasf.jisho.service.sign.in;

import com.hzlucasf.jisho.model.jwt.response.JwtResponse;
import com.hzlucasf.jisho.service.jwt.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class SignInService {
    private final JwtService jwtService;

    public SignInService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public JwtResponse signIn(Authentication authentication) {
        return jwtService.generateJwt(authentication);
    }
}
