package com.sj.chat.user.dto;

import org.springframework.util.StringUtils;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserSignupRequest(
    @Email @Size(max = 50) String email,
    @NotBlank @Size(min = 8, max = 72) String password,
    @NotBlank @Size(max = 20) String name,
    @Size(max = 13) @Pattern(regexp = "^\\+82(10\\d{8}|1[16789]\\d{7,8}|2\\d{7,8}|[3-6][1-5]\\d{7,8}|70\\d{8})$") String phoneNumber,
    @NotBlank @Size(max = 20) String handle
) {
    public UserSignupRequest {
        if (email == null && phoneNumber == null)
            throw new IllegalArgumentException("이메일과 전화번호 중 하나는 필수입니다.");
        email = StringUtils.hasText(email) ? email : null;
        phoneNumber = StringUtils.hasText(phoneNumber) ? phoneNumber : null;
    }
}
