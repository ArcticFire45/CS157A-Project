create database pokemon_trader;
create user 'springuser'@'%' identified by 'password';
grant all on pokemon_trader.* to 'springuser'@'%';