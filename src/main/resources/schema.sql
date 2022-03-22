DROP TABLE IF EXISTS myfriends;

CREATE TABLE myfriends
(
                       id SERIAL primary key,
                       firstname VARCHAR(255) not null,
                       lastname VARCHAR(255) not null,
                       email VARCHAR (255) not null unique,
                       password VARCHAR (255) not null
    );

