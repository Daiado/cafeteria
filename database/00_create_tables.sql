create table account
(
    id                 uuid         not null primary key unique,
    created_date       timestamp    not null,
    created_by         uuid         not null,
    last_modified_date timestamp    not null,
    last_modified_by   uuid         not null,
    name               varchar(60)  not null,
    email              varchar(60)  not null,
    password           varchar(254) not null,
    role               varchar(25)  not null
);


create table product
(
    id                 uuid         not null primary key unique,
    created_date       timestamp    not null,
    created_by         uuid         not null,
    last_modified_date timestamp    not null,
    last_modified_by   uuid         not null,
    product_type       varchar(60)  not null,
    description        varchar(60)  not null,
    calories           numeric      not null
);

create table user_order
(
    id                 uuid         not null primary key unique,
    main_course_id     uuid
        constraint fk_main_course_product references product,
    beverage_id        uuid
        constraint fk_beverage_product references product,
    created_date       timestamp    not null,
    created_by         uuid         not null,
    last_modified_date timestamp    not null,
    last_modified_by   uuid         not null
);