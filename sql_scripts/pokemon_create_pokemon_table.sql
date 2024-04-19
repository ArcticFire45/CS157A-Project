use pokemon_trader;

create Table if not exists pokemon(
pokemon_id INTEGER PRIMARY KEY,
poke_name varchar(30)
);


insert into pokemon
Values
(1, "bulbasaur"),
(2, "ivysaur"),
(3, "venasaur");

select * from pokemon;