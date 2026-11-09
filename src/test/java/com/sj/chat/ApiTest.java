package com.sj.chat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = {ChatApplication.class,
    FixtureConfiguration.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public @interface ApiTest {

}
