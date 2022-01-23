CREATE TABLE people
(
    id             serial PRIMARY KEY,
    telegram_login varchar(50),
    name           varchar(50),
    surname        varchar(50),
    city           varchar(20),
    role_id        int,
    group_id       int,
    FOREIGN KEY (role_id) REFERENCES roles (id),
    FOREIGN KEY (group_id) REFERENCES groups (id)
);

CREATE TABLE messages
(
    id        serial PRIMARY KEY,
    date_time int,
    message   varchar(300),
    person_id int,
    FOREIGN KEY (person_id) REFERENCES people(id)
);

CREATE TABLE groups
(
    id          serial PRIMARY KEY,
    group_name  varchar(30),
    group_color varchar(30)
);


CREATE TABLE roles
(
    id   serial PRIMARY KEY,
    role varchar(20)
);

INSERT INTO roles VALUES (1, 'Student'),
                         (2, 'Team Lead'),
                         (3, 'Mentor');

INSERT INTO groups VALUES (1, 'First', 'Red'),
                         (2, 'Second', 'Blue'),
                         (3, 'Third', 'Yellow');