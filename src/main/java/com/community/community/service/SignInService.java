package com.community.community.service;

import com.community.community.config.jwt.JwtTokenProvider;
import com.community.community.data.domain.User;
import com.community.community.data.domain.SignInDto;
import com.community.community.exception.WrongApproachException;
import com.community.community.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.community.community.exception.ErrorMessage.USER_NOT_FOUND;
import static com.community.community.exception.ErrorMessage.WRONG_PASSWORD;

@Service
@RequiredArgsConstructor
@Transactional
public class SignInService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public String signIn (SignInDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new WrongApproachException(USER_NOT_FOUND));

        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new WrongApproachException(WRONG_PASSWORD);
        }

        String token = jwtTokenProvider.createToken(userDto.getEmail());
        user.setToken(token);
        return token;
    }
}
