use pokemon_trader;

create Table if not exists pokemon(
pokemon_id INTEGER PRIMARY KEY,
poke_name varchar(30)
);


insert into pokemontemplate
Values
(1, "bulbasaur", "grass", "poison", ""),
(2, "ivysaur", "grass", "poison", ""),
(3, "venasaur", "grass", "poison", "");

select * from pokemon;