create table if not exists user (
    id varchar(20) not null,
    name varchar(40) not null,
    version int not null,
    primary key (id)
);
