package com.sj.chat.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name ="friends" )
@EntityListeners(AuditingEntityListener.class)
@IdClass(FriendId.class)
public class Friend {
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

}
