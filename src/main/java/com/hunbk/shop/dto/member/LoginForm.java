package com.hunbk.shop.dto.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginForm {

    @NotBlank(message = "공백은 허용되지 않습니다.")
    private String id;

    @NotBlank(message = "공백은 허용되지 않습니다.")
    private String password;

}
