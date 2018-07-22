create table user(
user_id bigint primary key not null auto_increment,
name varchar(100),
dob date,
created_date datetime,
is_active char);


create table book(
book_id bigint primary key not null auto_increment,
name varchar(100),
author varchar(100),
genre varchar(20),
user_id bigint,
created_date datetime,
is_active char,
foreign key (user_id) references user(user_id)
);

create table library(
library_id bigint primary key not null auto_increment,
name varchar(50),
user_id bigint,
created_date datetime,
is_active char,
foreign key (user_id) references user(user_id)
);

create table library_book(
library_book_id bigint primary key not null auto_increment,
user_id bigint,
library_id bigint,
book_id bigint,
created_date datetime,
is_active char,
foreign key (user_id) references user(user_id),
foreign key (library_id) references library(library_id),
foreign key (book_id) references book(book_id)
);