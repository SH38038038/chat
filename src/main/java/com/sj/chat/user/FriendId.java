package com.sj.chat.user;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class FriendId implements Serializable {
    private Long user;
    private Long friend;
}
