package com.sj.chat.user.dto;

import org.springframework.util.StringUtils;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserSignupRequest(
    @Email @Size(max= 50) String email,
    @NotBlank @Size(min=8,max=72) String password,
    @NotBlank @Size(max = 20) String name,
    @Size(max = 13) String phoneNumber,
    @NotBlank @Size(max = 20) String handle
) {
    public UserSignupRequest {
        email = StringUtils.hasText(email) ? email : null;
        phoneNumber = StringUtils.hasText(phoneNumber) ? phoneNumber : null;
    }

    @AssertTrue(message = "이메일과 전화번호 중 하나는 필수입니다.")
    public boolean isIdPresent() {
        return email != null || phoneNumber != null;
    }
}
