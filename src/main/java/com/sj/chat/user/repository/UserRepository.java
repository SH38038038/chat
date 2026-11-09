package com.sj.chat.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.sj.chat.user.User;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String email);
    boolean existsByHandle(String handle);
}
