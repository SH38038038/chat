package com.sj.chat.room;

import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sj.chat.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room_members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@IdClass(RoomMemberId.class)
public class RoomMember implements Persistable<RoomMemberId> {
    @Id
    @JoinColumn(name = "room_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRoom chatRoom;

    @Id
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomMemberRole role;

    @Column(nullable = false)
    private Long joinedMessageId;

    @Column(nullable = false)
    private Long lastReadMessageId;

    @Column(nullable = false)
    private boolean pinned;

    @Column(nullable = false)
    private boolean mute;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime joinedAt;

    @Column
    private LocalDateTime leftAt;

    @Override
    public @Nullable RoomMemberId getId() {
        return new RoomMemberId(user.getId(), chatRoom.getId());
    }

    @Override
    public boolean isNew() {
        return joinedAt == null;
    }
}
