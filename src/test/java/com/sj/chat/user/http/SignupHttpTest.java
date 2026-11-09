package com.sj.chat.user.http;

import static com.sj.chat.TestDataGenerator.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.sj.chat.ApiTest;
import com.sj.chat.user.dto.UserSignupRequest;

@ApiTest
@DisplayName("회원가입 API - POST")
public class SignupHttpTest {

    public static final String SIGNUP_URI = "/api/users";
    private final RestClient client;

    @Autowired
    public SignupHttpTest(Environment environment) {
        this.client = RestClient.builder().baseUrl("http://localhost:"+environment.getRequiredProperty("local.server.port")).build();
    }

    @Test
    void 정상적으로_요청하면_201_CREATED를_반환한다(){
        //given
        String email = generateEmail();
        String password = generatePassword();
        UserSignupRequest signupRequest = new UserSignupRequest(email, password, "Tester", "+821012345678",
            "handle");

        // when
        ResponseEntity<Void> response = client.post()
            .uri(SIGNUP_URI)
            .body(signupRequest)
            .retrieve()
            .toEntity(Void.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
