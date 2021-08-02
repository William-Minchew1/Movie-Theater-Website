create table Theaters(
Zip int not null,
TheaterName varchar(50),
TheaterAddress varchar(50),
primary key (TheaterName)
);

/* insert records */
insert into Theaters values (75034, 'AMC DINE-IN Stonebriar 24', '2601 Preston Road Ste 300 Frisco, Texas 75034');
insert into Theaters values (75254, 'Village On The Parkway 9', '5100 Belt Line Rd, Ste 220 Addison, Texas 75254');
insert into Theaters values (75240, 'AMC Valley View 16', '13331 Preston Rd Ste 2300 Dallas, Texas 75240');

create table Movies(
TheaterName varchar(50),
MovieName varchar(50),
Description varchar(1000),
primary key (MovieName, TheaterName),
foreign key (TheaterName) references Theaters(TheaterName)
);

/* insert records */
insert into Movies values ('AMC DINE-IN Stonebriar 24', 'F9 The Fast Saga', 'F9 is the ninth chapter in the saga that has endured for almost two decades and has earned more than $5 billion around the world. Vin Diesel"s Dom Toretto is leading a quiet life off the grid with Letty and his son, little Brian, but they know that danger always lurks just over their peaceful horizon. This time, that threat will force Dom to confront the sins of his past if he"s going to save those he loves most. His crew joins together to stop a world-shattering plot led by the most skilled assassin and high-performance driver they"ve ever encountered: a man who also happens to be Dom"s forsaken brother, Jakob (John Cena, next year"s The Suicide Squad). F9 sees the return of Justin Lin as director, who helmed the third, fourth, fifth and sixth chapters of the series when it transformed into a global blockbuster.');
insert into Movies values ('AMC DINE-IN Stonebriar 24', 'Snake Eyes', 'A legendary warrior. His epic origin story.');
insert into Movies values ('AMC DINE-IN Stonebriar 24', 'A Quiet Place Part II', 'Following the deadly events at home, the Abbott family (Emily Blunt, Millicent Simmonds, Noah Jupe) must now face the terrors of the outside world as they continue their fight for survival in silence. Forced to venture into the unknown, they quickly realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path in this terrifyingly suspenseful thriller written and directed by John Krasinski.');

insert into Movies values ('AMC DINE-IN Stonebriar 24', 'Black Widow', 'In Marvel Studios" action-packed spy thriller Black Widow, Natasha Romanoff aka Black Widow confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.');
insert into Movies values ('AMC DINE-IN Stonebriar 24', 'Escape Room Tournament of Champions', 'Escape Room Tournament of Champions is the sequel to the box office hit psychological thriller that terrified audiences around the world. In this installment, six people unwittingly find themselves locked in another series of escape rooms, slowly uncovering what they have in common to survive…and discovering they’ve all played the game before.');
insert into Movies values ('AMC DINE-IN Stonebriar 24', 'The Boss Baby Family Business', 'Ted is a hedge fund CEO. But a new boss baby with a cutting-edge approach and a can-do attitude is about to bring them together again... and inspire a new family business. Tim and his wife, Carol (Eva Longoria), the breadwinner of the family, live in the suburbs with their super-smart 7-year-old daughter Tabitha (Ariana Greenblatt, Avengers: Infinity War), and adorable new infant Tina (Amy Sedaris, Netflix"s BoJack Horseman).');

insert into Movies values ('AMC DINE-IN Stonebriar 24', 'Peter Rabbit 2 The Runaway', 'In PETER RABBIT 2: THE RUNAWAY, the lovable rogue is back. Bea, Thomas, and the rabbits have created a makeshift family, but despite his best efforts, Peter can"t seem to shake his mischievous reputation. Adventuring out of the garden, Peter finds himself in a world where his mischief is appreciated, but when his family risks everything to come looking for him, Peter must figure out what kind of bunny he wants to be.');
insert into Movies values ('AMC DINE-IN Stonebriar 24', 'Cruella', 'Cruella follows her life story and her attempts to get revenge on Baroness von Hellman. Cruella teams up with thieves Jasper and Horace, with Artie joining them for her final scheme of wrecking the Baroness" charity ball.');
insert into Movies values ('AMC DINE-IN Stonebriar 24', 'Chinese Doctors', 'Chinese Doctors follows the story of frontline medical workers fought against the COVID-19 pandemic in Wuhan Jinyintan Hospital, Hubei, China.');

--Differnt movies for a given theater instance. I just changed the order but note
--the change
insert into Movies values ('Village On The Parkway 9', 'Peter Rabbit 2 The Runaway', 'In PETER RABBIT 2: THE RUNAWAY, the lovable rogue is back. Bea, Thomas, and the rabbits have created a makeshift family, but despite his best efforts, Peter can"t seem to shake his mischievous reputation. Adventuring out of the garden, Peter finds himself in a world where his mischief is appreciated, but when his family risks everything to come looking for him, Peter must figure out what kind of bunny he wants to be.');
insert into Movies values ('Village On The Parkway 9', 'Cruella', 'Cruella follows her life story and her attempts to get revenge on Baroness von Hellman. Cruella teams up with thieves Jasper and Horace, with Artie joining them for her final scheme of wrecking the Baroness" charity ball.');
insert into Movies values ('Village On The Parkway 9', 'Chinese Doctors', 'Chinese Doctors follows the story of frontline medical workers fought against the COVID-19 pandemic in Wuhan Jinyintan Hospital, Hubei, China.');

insert into Movies values ('Village On The Parkway 9', 'F9 The Fast Saga', 'F9 is the ninth chapter in the saga that has endured for almost two decades and has earned more than $5 billion around the world. Vin Diesel"s Dom Toretto is leading a quiet life off the grid with Letty and his son, little Brian, but they know that danger always lurks just over their peaceful horizon. This time, that threat will force Dom to confront the sins of his past if he"s going to save those he loves most. His crew joins together to stop a world-shattering plot led by the most skilled assassin and high-performance driver they"ve ever encountered: a man who also happens to be Dom"s forsaken brother, Jakob (John Cena, next year"s The Suicide Squad). F9 sees the return of Justin Lin as director, who helmed the third, fourth, fifth and sixth chapters of the series when it transformed into a global blockbuster.');
insert into Movies values ('Village On The Parkway 9', 'Snake Eyes', 'A legendary warrior. His epic origin story.');
insert into Movies values ('Village On The Parkway 9', 'A Quiet Place Part II', 'Following the deadly events at home, the Abbott family (Emily Blunt, Millicent Simmonds, Noah Jupe) must now face the terrors of the outside world as they continue their fight for survival in silence. Forced to venture into the unknown, they quickly realize that the creatures that hunt by sound are not the only threats that lurk beyond the sand path in this terrifyingly suspenseful thriller written and directed by John Krasinski.');

insert into Movies values ('Village On The Parkway 9', 'Black Widow', 'In Marvel Studios" action-packed spy thriller Black Widow, Natasha Romanoff aka Black Widow confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.');
insert into Movies values ('Village On The Parkway 9', 'Escape Room Tournament of Champions', 'Escape Room Tournament of Champions is the sequel to the box office hit psychological thriller that terrified audiences around the world. In this installment, six people unwittingly find themselves locked in another series of escape rooms, slowly uncovering what they have in common to survive…and discovering they’ve all played the game before.');
insert into Movies values ('Village On The Parkway 9', 'The Boss Baby Family Business', 'Ted is a hedge fund CEO. But a new boss baby with a cutting-edge approach and a can-do attitude is about to bring them together again... and inspire a new family business. Tim and his wife, Carol (Eva Longoria), the breadwinner of the family, live in the suburbs with their super-smart 7-year-old daughter Tabitha (Ariana Greenblatt, Avengers: Infinity War), and adorable new infant Tina (Amy Sedaris, Netflix"s BoJack Horseman).');

--Differnt movies for a given theater instance. I just changed the order and 
--removed 3 movies but note the change on the website.
insert into Movies values ('AMC Valley View 16', 'Black Widow', 'In Marvel Studios" action-packed spy thriller Black Widow, Natasha Romanoff aka Black Widow confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger.');
insert into Movies values ('AMC Valley View 16', 'Escape Room Tournament of Champions', 'Escape Room Tournament of Champions is the sequel to the box office hit psychological thriller that terrified audiences around the world. In this installment, six people unwittingly find themselves locked in another series of escape rooms, slowly uncovering what they have in common to survive…and discovering they’ve all played the game before.');
insert into Movies values ('AMC Valley View 16', 'The Boss Baby Family Business', 'Ted is a hedge fund CEO. But a new boss baby with a cutting-edge approach and a can-do attitude is about to bring them together again... and inspire a new family business. Tim and his wife, Carol (Eva Longoria), the breadwinner of the family, live in the suburbs with their super-smart 7-year-old daughter Tabitha (Ariana Greenblatt, Avengers: Infinity War), and adorable new infant Tina (Amy Sedaris, Netflix"s BoJack Horseman).');

insert into Movies values ('AMC Valley View 16', 'Peter Rabbit 2 The Runaway', 'In PETER RABBIT 2: THE RUNAWAY, the lovable rogue is back. Bea, Thomas, and the rabbits have created a makeshift family, but despite his best efforts, Peter can"t seem to shake his mischievous reputation. Adventuring out of the garden, Peter finds himself in a world where his mischief is appreciated, but when his family risks everything to come looking for him, Peter must figure out what kind of bunny he wants to be.');
insert into Movies values ('AMC Valley View 16', 'Cruella', 'Cruella follows her life story and her attempts to get revenge on Baroness von Hellman. Cruella teams up with thieves Jasper and Horace, with Artie joining them for her final scheme of wrecking the Baroness" charity ball.');
insert into Movies values ('AMC Valley View 16', 'Chinese Doctors', 'Chinese Doctors follows the story of frontline medical workers fought against the COVID-19 pandemic in Wuhan Jinyintan Hospital, Hubei, China.');


create table ListTimes(
MovieName varchar(50),
ListTime varchar(10),
TheaterName varchar(50),
primary key (MovieName, ListTime, TheaterName),
foreign key (MovieName, TheaterName) references Movies(MovieName, TheaterName)
);

/* insert records */
insert into ListTimes values ('F9 The Fast Saga', '4:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('F9 The Fast Saga', '5:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('F9 The Fast Saga', '6:00 pm', 'AMC DINE-IN Stonebriar 24');

insert into ListTimes values ('Snake Eyes', '12:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Snake Eyes', '1:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Snake Eyes', '2:00 pm', 'AMC DINE-IN Stonebriar 24');

insert into ListTimes values ('A Quiet Place Part II', '10:00 am', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('A Quiet Place Part II', '11:00 am', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('A Quiet Place Part II', '11:00 pm', 'AMC DINE-IN Stonebriar 24');

insert into ListTimes values ('Black Widow', '8:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Black Widow', '9:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Black Widow', '11:00 pm', 'AMC DINE-IN Stonebriar 24');

insert into ListTimes values ('Escape Room Tournament of Champions', '8:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Escape Room Tournament of Champions', '9:15 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Escape Room Tournament of Champions', '10:30 pm', 'AMC DINE-IN Stonebriar 24');

insert into ListTimes values ('The Boss Baby Family Business', '5:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('The Boss Baby Family Business', '7:30 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('The Boss Baby Family Business', '8:50 pm', 'AMC DINE-IN Stonebriar 24');

insert into ListTimes values ('Peter Rabbit 2 The Runaway', '8:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Peter Rabbit 2 The Runaway', '9:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Peter Rabbit 2 The Runaway', '9:45 pm', 'AMC DINE-IN Stonebriar 24');

insert into ListTimes values ('Cruella', '6:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Cruella', '8:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Cruella', '10:00 pm', 'AMC DINE-IN Stonebriar 24');

insert into ListTimes values ('Chinese Doctors', '4:00 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Chinese Doctors', '6:30 pm', 'AMC DINE-IN Stonebriar 24');
insert into ListTimes values ('Chinese Doctors', '9:00 pm', 'AMC DINE-IN Stonebriar 24');


insert into ListTimes values ('F9 The Fast Saga', '4:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('F9 The Fast Saga', '5:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('F9 The Fast Saga', '6:00 pm', 'Village On The Parkway 9');

insert into ListTimes values ('Snake Eyes', '12:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Snake Eyes', '1:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Snake Eyes', '2:00 pm', 'Village On The Parkway 9');

insert into ListTimes values ('A Quiet Place Part II', '10:00 am', 'Village On The Parkway 9');
insert into ListTimes values ('A Quiet Place Part II', '11:00 am', 'Village On The Parkway 9');
insert into ListTimes values ('A Quiet Place Part II', '11:00 pm', 'Village On The Parkway 9');

insert into ListTimes values ('Black Widow', '8:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Black Widow', '9:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Black Widow', '11:00 pm', 'Village On The Parkway 9');

insert into ListTimes values ('Escape Room Tournament of Champions', '8:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Escape Room Tournament of Champions', '9:15 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Escape Room Tournament of Champions', '10:30 pm', 'Village On The Parkway 9');

insert into ListTimes values ('The Boss Baby Family Business', '5:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('The Boss Baby Family Business', '7:30 pm', 'Village On The Parkway 9');
insert into ListTimes values ('The Boss Baby Family Business', '8:50 pm', 'Village On The Parkway 9');

insert into ListTimes values ('Peter Rabbit 2 The Runaway', '8:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Peter Rabbit 2 The Runaway', '9:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Peter Rabbit 2 The Runaway', '9:45 pm', 'Village On The Parkway 9');

insert into ListTimes values ('Cruella', '6:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Cruella', '8:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Cruella', '10:00 pm', 'Village On The Parkway 9');

insert into ListTimes values ('Chinese Doctors', '4:00 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Chinese Doctors', '6:30 pm', 'Village On The Parkway 9');
insert into ListTimes values ('Chinese Doctors', '9:00 pm', 'Village On The Parkway 9');


insert into ListTimes values ('Black Widow', '8:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('Black Widow', '9:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('Black Widow', '11:00 pm', 'AMC Valley View 16');

insert into ListTimes values ('Escape Room Tournament of Champions', '8:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('Escape Room Tournament of Champions', '9:15 pm', 'AMC Valley View 16');
insert into ListTimes values ('Escape Room Tournament of Champions', '10:30 pm', 'AMC Valley View 16');

insert into ListTimes values ('The Boss Baby Family Business', '5:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('The Boss Baby Family Business', '7:30 pm', 'AMC Valley View 16');
insert into ListTimes values ('The Boss Baby Family Business', '8:50 pm', 'AMC Valley View 16');

insert into ListTimes values ('Peter Rabbit 2 The Runaway', '8:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('Peter Rabbit 2 The Runaway', '9:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('Peter Rabbit 2 The Runaway', '9:45 pm', 'AMC Valley View 16');

insert into ListTimes values ('Cruella', '6:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('Cruella', '8:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('Cruella', '10:00 pm', 'AMC Valley View 16');

insert into ListTimes values ('Chinese Doctors', '4:00 pm', 'AMC Valley View 16');
insert into ListTimes values ('Chinese Doctors', '6:30 pm', 'AMC Valley View 16');
insert into ListTimes values ('Chinese Doctors', '9:00 pm', 'AMC Valley View 16');
