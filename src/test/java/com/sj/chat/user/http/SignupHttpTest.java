package com.sj.chat.user.http;

import static com.sj.chat.TestDataGenerator.generateEmail;
import static com.sj.chat.TestDataGenerator.generateHandle;
import static com.sj.chat.TestDataGenerator.generatePassword;
import static com.sj.chat.TestDataGenerator.generatePhoneNumber;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sj.chat.ApiTest;
import com.sj.chat.user.UserApiFixture;
import com.sj.chat.user.dto.UserSignupRequest;

@ApiTest
@DisplayName("회원가입 API - POST")
public class SignupHttpTest {

    @Autowired
    UserApiFixture fixture;

    @Test
    void 정상적으로_요청하면_201_CREATED를_반환한다() {
        //given
        String email = generateEmail();
        String password = generatePassword();
        String phoneNumber = generatePhoneNumber();
        String handle = generateHandle();
        UserSignupRequest signupRequest = new UserSignupRequest(email, password, "Tester", phoneNumber,
            handle);

        // when
        ResponseEntity<Void> response = fixture.signup(signupRequest);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void 이미_등록된_이메일이면_500_INTERNAL_SERVER_ERROR를_반환한다() {
        // given
        String email = generateEmail();
        UserSignupRequest firstSignupRequest = new UserSignupRequest(email, generatePassword(), "Tester1",
            generatePhoneNumber(), generateHandle());
        UserSignupRequest secondSignupRequest = new UserSignupRequest(email, generatePassword(), "Tester2",
            generatePhoneNumber(), generateHandle());

        // when
        fixture.signup(firstSignupRequest);

        ResponseEntity<Void> response = fixture.signup(secondSignupRequest);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void 이미_등록된_전화번호면_500_INTERNAL_SERVER_ERROR를_반환한다() {
        String phoneNumber = generatePhoneNumber();
        UserSignupRequest firstSignupRequest = new UserSignupRequest(generateEmail(), generatePassword(), "Tester1",
            phoneNumber, generateHandle());
        UserSignupRequest secondSignupRequest = new UserSignupRequest(generateEmail(), generatePassword(), "Tester2",
            phoneNumber, generateHandle());

        // when
        fixture.signup(firstSignupRequest);
        ResponseEntity<Void> response = fixture.signup(secondSignupRequest);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
