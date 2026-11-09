package com.sj.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.sj.chat.user.UserApiFixture;

public class FixtureConfiguration {

    @Bean
    @Scope("prototype")
    public UserApiFixture userFixture(@Autowired Environment environment) {
        return UserApiFixture.create(environment);
    }

}
