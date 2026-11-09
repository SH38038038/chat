package com.sj.chat.user.service;

import static com.sj.chat.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sj.chat.user.User;
import com.sj.chat.user.dto.UserSignupRequest;
import com.sj.chat.user.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock BCryptPasswordEncoder passwordEncoder;
    @Mock UserRepository userRepository;
    @InjectMocks UserService userService;

    @Test
    void 중복_이메일_가입_시_RuntimeException이_발생한다(){
        //given
        String email = generateEmail();
        UserSignupRequest requestBody = new UserSignupRequest(email, "testPassword", "Tester",
            "+821012345678", "Tester");

        given(userRepository.existsByEmail(email)).willReturn(true);

        //when
        assertThatThrownBy(() -> userService.signup(requestBody)).isInstanceOf(RuntimeException.class);

        //then
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void 중복_전화번호_가입_시_RuntimeException이_발생한다(){
        //given
        String phoneNumber = generatePhoneNumber();

        UserSignupRequest requestBody = new UserSignupRequest(generateEmail(), "testPassword", "Tester",
            phoneNumber, "Tester");

        given(userRepository.existsByPhoneNumber(phoneNumber)).willReturn(true);

        //when
        assertThatThrownBy(() -> userService.signup(requestBody)).isInstanceOf(RuntimeException.class);

        //then
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void 중복_handle_가입_시_RuntimeException이_발생한다(){
        //given

        String handle = generateHandle();
        UserSignupRequest requestBody = new UserSignupRequest(generateEmail(), "testPassword", "Tester",
            generatePhoneNumber(), handle);

        given(userRepository.existsByHandle(handle)).willReturn(true);

        //when
        assertThatThrownBy(() -> userService.signup(requestBody)).isInstanceOf(RuntimeException.class);

        //then
        verify(userRepository, never()).save(any(User.class));
    }
}