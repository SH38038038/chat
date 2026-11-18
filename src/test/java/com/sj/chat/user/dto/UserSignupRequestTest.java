package com.sj.chat.user.dto;

import static com.sj.chat.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserSignupRequestTest {
    @Test
    void 전화번호와_이메일_모두_있을_때는_DTO가_생성된다(){
        // given
        String email = generateEmail();
        String phoneNumber = generatePhoneNumber();
        String handle = generateHandle();

        // when
        UserSignupRequest dto = new UserSignupRequest(email, generatePassword(), "Tester1", phoneNumber,
            handle);

        // then
        assertThat(dto).isNotNull();
        assertThat(dto.email()).isEqualTo(email);
        assertThat(dto.phoneNumber()).isEqualTo(phoneNumber);
        assertThat(dto.handle()).isEqualTo(handle);
    }

    @Test
    void 전화번호와_이메일_모두_없으면_DTO_생성이_실패한다(){
        //when & then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new UserSignupRequest(null, generatePassword(), "Tester1", null, generateHandle());
        });
        //
        assertEquals("이메일과 전화번호 중 하나는 필수입니다.", e.getMessage());
    }
}