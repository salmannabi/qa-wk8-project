-- drop schema springproject;

-- CREATE SCHEMA IF NOT EXISTS springproject;

-- USE springproject ;

drop table if exists car CASCADE;

create table car(
	id int auto_increment,
    make varchar(255) not null,
    model varchar(255) not null,
    fuel_type varchar(255) not null,
    body_type varchar(255) not null,
    gearbox varchar(255) not null,
    primary key (id)
)