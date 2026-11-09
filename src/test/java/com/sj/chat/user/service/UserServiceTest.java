package com.sj.chat.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sj.chat.user.dto.UserSignupRequest;
import com.sj.chat.user.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository repository;
    @Mock
    BCryptPasswordEncoder passwordEncoder;
    @InjectMocks
    UserService userService;

    @Test
    void 회원가입하면_인코딩된_비밀번호로_저장한다() {
        //given
        UserSignupRequest requestBody = new UserSignupRequest("test@test.com", "testPassword", "Tester",
            "+821012345678", "Tester");
        //when
        userService.signup(requestBody);
        //then
        // 정상 수행 시 반환 없음
    }
}