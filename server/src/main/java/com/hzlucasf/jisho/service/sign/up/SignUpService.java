package com.hzlucasf.jisho.service.sign.up;

import com.hzlucasf.jisho.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    private final UserRepository userRepository;

    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
