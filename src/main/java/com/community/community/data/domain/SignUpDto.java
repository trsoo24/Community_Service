package com.community.community.data.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
    private String email;
    private String nickName;
    private String password;
}
