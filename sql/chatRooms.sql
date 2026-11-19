DROP TABLE IF EXISTS chat_rooms;


create table chat_rooms(
    id bigint AUTO_INCREMENT PRIMARY KEY,
    type varchar(6) NOT NULL,
    image_key varchar(100) NOT NULL,
    direct_key varchar(100) UNIQUE,
    member_count int NOT NULL,
    last_message_id bigint NOT NULL,
    last_message_preview varchar(50) NOT NULL,
    last_message_at datetime NOT NULL,
    created_at datetime NOT NULL,

    constraint chk_chat_rooms_member_count
        check (member_count >= 0)
)

