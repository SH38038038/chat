package com.sj.chat.room;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class RoomMemberId implements Serializable {
    private Long user;
    private Long chatRoom;
}
