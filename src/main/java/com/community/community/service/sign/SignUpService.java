package com.community.community.service.sign;

import com.community.community.data.user.dto.SignUpDto;
import com.community.community.data.user.model.User;
import com.community.community.exception.WrongApproachException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.community.community.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import static com.community.community.exception.ErrorMessage.*;

@Service
@RequiredArgsConstructor
@Transactional
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signUp(SignUpDto userDto) {
        String email = userDto.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
            throw new WrongApproachException(ALREADY_REGISTERED);
        } else if (email == null) {
            throw new WrongApproachException(FILL_EMAIL_BLANK);
        } else if (userDto.getPassword() == null) {
            throw new WrongApproachException(FILL_PASSWORD_BLANK);
        } else if (userRepository.findByNickName(userDto.getNickName()).isPresent()) {
            throw new WrongApproachException(DUPLICATED_NICKNAME);
        }

        User user = userRepository.save(User.builder()
                        .email(userDto.getEmail())
                        .password(passwordEncoder.encode(userDto.getPassword()))
                        .nickName(userDto.getNickName())
                        .build());

        return user;
    }
}
