package com.sj.chat.user;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.sj.chat.user.dto.UserSignupRequest;

public record UserApiFixture(RestClient client) {
    public static final String SIGNUP_URI = "/api/users";

    public static UserApiFixture create(Environment environment) {
        RestClient client = RestClient.builder()
            .baseUrl("http://localhost:" + environment.getRequiredProperty("local.server.port")).build();
        return new UserApiFixture(client);
    }

    public ResponseEntity<Void> signup(UserSignupRequest request) {
        return this.post(SIGNUP_URI, request, Void.class);
    }

    public <T> ResponseEntity<T> post(String uri, Object requestBody,
        Class<T> responseType) {
        return this.client().post()
            .uri(uri)
            .body(requestBody)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
            }))
            .onStatus(HttpStatusCode::is5xxServerError, ((request, response) -> {
            }))
            .toEntity(responseType);
    }

}
