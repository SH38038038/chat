package com.sj.chat.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.sj.chat.user.User;
import com.sj.chat.user.dto.UserSignupRequest;
import com.sj.chat.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(UserSignupRequest signupRequest) {
        validEmailExist(signupRequest.email());
        validPhoneNumberExist(signupRequest.phoneNumber());
        validHandleExist(signupRequest.handle());
        User signupUser = User.signup(signupRequest.email(), signupRequest.phoneNumber(), passwordEncoder.encode(signupRequest.password()),
            signupRequest.name(), signupRequest.handle());
        repository.save(signupUser);
    }

    private void validEmailExist(String email) {
        if (StringUtils.hasText(email) && repository.existsByEmail(email)) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
    }

    private void validPhoneNumberExist(String phoneNumber) {
        if (StringUtils.hasText(phoneNumber) && repository.existsByPhoneNumber(phoneNumber)) {
            throw new RuntimeException("이미 존재하는 전화번호입니다.");
        }
    }

    private void validHandleExist(String handle) {
        if (StringUtils.hasText(handle) && repository.existsByHandle(handle)) {
            throw new RuntimeException("이미 존재하는 태그입니다.");
        }
    }
}
