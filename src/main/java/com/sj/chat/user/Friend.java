package com.sj.chat.user;

import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "friends")
@EntityListeners(AuditingEntityListener.class)
@IdClass(FriendId.class)
public class Friend implements Persistable<FriendId> {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private User friend;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FriendStatus status;

    @Column(nullable = false)
    private boolean favorite;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Override
    public @Nullable FriendId getId() {
        return new FriendId(user.getId(), friend.getId());
    }

    @Override
    public boolean isNew() {
        return createdAt == null;
    }
}
