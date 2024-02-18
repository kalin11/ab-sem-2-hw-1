--liquibase formatted sql

--changeset Artem Lysenko:create-schema
create table if not exists authors (
    id serial primary key,
    name varchar(255) not null check ( length(name) > 0 ),
    surname varchar(255) not null check ( length(surname) > 0 ),
    age integer not null check ( age > 0 and age < 120 )
);

create sequence if not exists authors_pk_seq start 1 increment 1;

alter table authors alter column id set default nextval('authors_pk_seq');
