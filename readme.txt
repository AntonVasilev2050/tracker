CREATE TABLE persons
(
    person_id      serial PRIMARY KEY,
    telegram_login varchar(50),
    name           varchar(50),
    surname        varchar,
    city           varchar(20),
    role_id        int,
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
);

CREATE TABLE roles
(
    role_id serial PRIMARY KEY,
    role    varchar(20)
);

CREATE TABLE messages
(
    message_id serial PRIMARY KEY,
    date_time  TIMESTAMP,
    message    varchar(300)
);

CREATE TABLE groups
(

)