create table customers(
    id bigserial primary key,
    email varchar(50) not null,
    pwd  varchar(100) not null,
    rol varchar(40) not null
);