package io.greengame.greengameio.services;

import io.greengame.greengameio.dtos.LogInDto;
import io.greengame.greengameio.dtos.SignUpDto;
import io.greengame.greengameio.dtos.UserDto;
import io.greengame.greengameio.dtos.UserMapper;
import io.greengame.greengameio.repository.UserRepository;
import io.greengame.greengameio.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public UserDto findByLogin(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found."));
        return userMapper.toUserDto(user);
    }

    public UserDto registerUser(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getLogin());

        if (optionalUser.isPresent()) {
            throw new RuntimeException("Login already exists");
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public  UserDto loginUser(LogInDto logInDto) {
        User user = userRepository.findByUsername(logInDto.getLogin())
                .orElseThrow(() -> new RuntimeException("Unknown user"));

        if (passwordEncoder.matches(CharBuffer.wrap(logInDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new RuntimeException("Invalid password");
    }
}
