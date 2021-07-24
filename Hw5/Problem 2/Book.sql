create table Books(
ISBN char(13) primary key,
Title varchar(50),
Pages int
);

/* insert records */
insert into Books values ('0-13-403732-4', 'C++ Programming', 1020);
insert into Books values ('0-13-376131-2', 'Java Programming', 1344);
insert into Books values ('0-13-257627-9', 'Data Structures', 640);
insert into Books values ('0-13-257637-6', 'Python', 648);
insert into Books values ('0-32-154140-5','Problem Solving', 1024);
insert into Books values ('1-43-024692-8', 'EJB 3', 452);


create table Authors(
AuthorID int primary key,
AuthorName varchar(50)
);

/* insert records */
insert into Authors values (1, 'Tony Gaddis');
insert into Authors values (2, 'Y.Daniel Liang');
insert into Authors values (3, 'Mark Allen Weiss');
insert into Authors values (4, 'Jonathan Wetherbee');
insert into Authors values (5, 'Chirag Rathod');


create table BookAuthors(
ISBN char(13),
AuthorID char(2),
Placeholder BOOLEAN,
primary key (ISBN, AuthorID),
foreign key (ISBN) references Books(ISBN),
foreign key (AuthorID) references Authors(AuthorID)
);

/* insert records */
insert into BookAuthors values ('0-13-403732-4', 1, false);
insert into BookAuthors values ('0-13-376131-2', 2, false);
insert into BookAuthors values ('0-13-257627-9', 3, false);
insert into BookAuthors values ('0-13-257637-6', 1, false);
insert into BookAuthors values ('0-32-154140-5', 3, false);
insert into BookAuthors values ('1-43-024692-8', 4, false);
insert into BookAuthors values ('1-43-024692-8', 5, false);
