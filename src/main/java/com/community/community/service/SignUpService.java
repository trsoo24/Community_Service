package com.community.community.service;

import com.community.community.data.domain.SignUpDto;
import com.community.community.data.domain.User;
import com.community.community.data.domain.SignInDto;
import com.community.community.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.community.community.repository.UserRepository;

import static com.community.community.exception.ErrorMessage.*;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signUp(SignUpDto userDto) {
        String email = userDto.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
            throw new CustomException(ALREADY_REGISTERED);
        } else if (email == null) {
            throw new CustomException(FILL_EMAIL_BLANK);
        } else if (userDto.getPassword() == null) {
            throw new CustomException(FILL_PASSWORD_BLANK);
        } else if (userRepository.findByNickName(userDto.getNickName()).isPresent()) {
            throw new CustomException(DUPLICATED_NICKNAME);
        }

        User user = userRepository.save(User.builder()
                        .email(userDto.getEmail())
                        .password(passwordEncoder.encode(userDto.getPassword()))
                        .nickName(userDto.getNickName())
                        .build());

        return user;
    }
}
