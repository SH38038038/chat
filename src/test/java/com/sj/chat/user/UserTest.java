package com.sj.chat.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 회원가입_메소드_정상_동작() {
        // given
        String email = "test@test.com";
        String password = "test";
        String name = "test";
        String handle = "test";
        String phoneNumber = "123456789";
        //when
        User createdUser = User.signup(email,phoneNumber,password,name,handle);
        //then
        assertThat(createdUser.getEmail()).isEqualTo(email);
        assertThat(createdUser.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(createdUser.getPasswordHash()).isEqualTo(password);
        assertThat(createdUser.getName()).isEqualTo(name);
        assertThat(createdUser.getHandle()).isEqualTo(handle);

    }
}