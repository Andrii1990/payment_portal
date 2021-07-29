create database payment_portal;

\c payment_portal;

create table clients
(
    client_id  serial not null
        constraint clients_pk
            primary key,
    first_name varchar(50) not null,
    last_name  varchar(50) not null
);

CREATE TYPE account_type AS ENUM ('card/simple');
create table account_numbers
(
    account_id  serial not null
        constraint account_numbers_pk
            primary key,
    client_id integer not null
        constraint client_id_fk
            references clients,
    account_num varchar(50) not null,
    account_type account_type not null,
    balance  numeric(14,2) not null
);

CREATE TYPE status AS ENUM ('ok','error');
create table payments
(
    payment_id serial not null
        constraint payments_pk
            primary key,
    source_acc_id integer not null
        constraint client_id_fk_1
            references clients,
    src_acc_num integer not null
        constraint account_id_fk_1
            references account_numbers,
    dest_acc_id integer not null
        constraint client_id_fk_2
            references clients,
    dest_acc_num integer not null
        constraint account_id_fk_2
            references account_numbers,
    amount numeric(14,2) not null,
    reason varchar(255) not null,
    status status not null,
    error_code varchar(10),
    timestamp timestamp not null
);






