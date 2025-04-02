package com.hzlucasf.jisho.service.sign.up;

import com.hzlucasf.jisho.exception.user.InvalidPasswordException;
import com.hzlucasf.jisho.exception.user.InvalidUsernameException;
import com.hzlucasf.jisho.exception.user.UserAlreadyRegisteredException;
import com.hzlucasf.jisho.model.role.Role;
import com.hzlucasf.jisho.model.user.User;
import com.hzlucasf.jisho.model.user.request.UserRequest;
import com.hzlucasf.jisho.model.user.response.UserResponse;
import com.hzlucasf.jisho.repository.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public SignUpService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse signUp(UserRequest userRequest) {
        if (!userRequest.getUsername().matches("^[a-zA-Z_]+$")) {
            throw new InvalidUsernameException("the username can only contain letters and underscores");
        }

        if (userRequest.getPassword().length() < 8) {
            throw new InvalidPasswordException("the password must be at least 8 characters long");
        }

        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new UserAlreadyRegisteredException("user already registered");
        }

        var user = new User(
                userRequest.getUsername(),
                userRequest.getPassword(),
                Role.USER
        );

        userRepository.save(user);

        return new UserResponse(user.getId(), user.getUsername());
    }
}
