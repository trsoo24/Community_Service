package com.community.community.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {

    // 유저 회원가입
    FILL_EMAIL_BLANK(HttpStatus.BAD_REQUEST, "이메일을 작성해주세요."),
    ALREADY_REGISTERED(HttpStatus.BAD_REQUEST, "이미 존재하는 계정입니다."),
    FILL_PASSWORD_BLANK(HttpStatus.BAD_REQUEST, "비밀번호를 작성해주세요."),
    // 유저 로그인
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "찾을 수 없는 이용자입니다."),
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호를 확인해주세요.")

    ;
    private final HttpStatus httpStatus;
    private final String message;
}
