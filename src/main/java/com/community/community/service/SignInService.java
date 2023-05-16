package com.community.community.service;

import com.community.community.config.jwt.JwtTokenProvider;
import com.community.community.data.domain.User;
import com.community.community.data.domain.UserDto;
import com.community.community.exception.CustomException;
import com.community.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.community.community.exception.ErrorMessage.USER_NOT_FOUND;
import static com.community.community.exception.ErrorMessage.WRONG_PASSWORD;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public String signIn (UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));

        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new CustomException(WRONG_PASSWORD);
        }

        return jwtTokenProvider.createToken(userDto.getEmail());
    }
}
