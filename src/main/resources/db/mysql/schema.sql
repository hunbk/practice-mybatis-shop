drop table if exists member;
drop table if exists item;
drop table if exists cart;

create table member
(
    member_no int auto_increment,
    id        varchar(20)  not null,
    password  varchar(255) not null,
    name      varchar(10)  not null,
    email     varchar(100) not null,
    primary key (member_no)
);

create table item
(
    item_no     int auto_increment,
    member_no   int          not null,
    name        varchar(20)  not null,
    category    varchar(20)  not null,
    price       int          not null,
    stock       int          not null,
    description text         not null,
    image_path  varchar(255) not null,
    primary key (item_no)
);

# 장바구니
create table cart
(
    member_no int not null,
    item_no   int not null,
    quantity  int not null,
    primary key (member_no, item_no)
);

# 찜하기
create table favorite
(
    member_no int not null,
    item_no   int not null,
    primary key (member_no, item_no)
);
