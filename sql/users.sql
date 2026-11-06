DROP TABLE IF EXISTS users;

create table users(
    id bigint,
    email varchar(50) ,
    phone_number varchar(13),
    phone_verified_at datetime,
    password_hash varchar(60) NOT NULL ,
    name varchar(20),
    handle varchar(20),
    status_message varchar(100),
    profile_image_key varchar(100),
    status varchar(10) not null,
    created_at datetime NOT NULL ,
    deleted_at datetime,

    constraint pk_id primary key (id),
    constraint unique_email unique (email),
    constraint unique_phone_number unique (phone_number),
    constraint unique_password_hash unique (password_hash),
    constraint unique_handle unique (handle)
);
