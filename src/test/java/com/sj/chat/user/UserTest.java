package com.sj.chat.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void getEmail을_호출하면_사용자_이메일을_반환한다() {
        // given
        User user = new User(
            1L, "test@test.com", "+821012345678", LocalDateTime.now(), "password_hash",
            "test", "@test", null, null, UserStatus.ACTIVE, LocalDateTime.now(), null
        );
        //when
        String email = user.getEmail();
        //then
        assertThat(email).isEqualTo(user.getEmail());

    }
}