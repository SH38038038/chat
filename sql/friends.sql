DROP TABLE IF EXISTS friends;

create table friends(
    user_id bigint,
    friend_id bigint,
    status VARCHAR(6) NOT NULL ,
    favorite boolean NOT NULL ,
    created_at datetime NOT NULL ,

    constraint pk_id primary key (user_id, friend_id),
    constraint fk_user_id foreign key (user_id) references users(id) on delete cascade ,
    constraint fk_friend_id foreign key (friend_id) references users(id) on delete cascade
)