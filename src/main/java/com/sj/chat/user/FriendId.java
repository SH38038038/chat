package com.sj.chat.user;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class FriendId implements Serializable {
    private Long user;
    private Long friend;
}
