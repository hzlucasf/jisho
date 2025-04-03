package com.hzlucasf.jisho.service.user;

import com.hzlucasf.jisho.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
