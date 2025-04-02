package com.hzlucasf.jisho.service.sign.up;

import com.hzlucasf.jisho.model.role.Role;
import com.hzlucasf.jisho.model.user.User;
import com.hzlucasf.jisho.model.user.request.UserRequest;
import com.hzlucasf.jisho.model.user.response.UserResponse;
import com.hzlucasf.jisho.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    private final UserRepository userRepository;

    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse signUp(UserRequest userRequest) {
        var user = new User(
                userRequest.getUsername(),
                userRequest.getPassword(),
                Role.USER
        );

        userRepository.save(user);

        return new UserResponse(user.getId(), user.getUsername());
    }
}
