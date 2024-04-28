import React from "react";
import usePokemons from "../hooks/usePokemons";
import Card from "./Card";

const PokemonPage = () => {
  const pokemons = usePokemons();

  return (
    <div>
      <h1>Pokemon Page</h1>
      <p>Welcome to the Pokemon Page!</p>
      <div
        style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}
      >
        {pokemons.map((pokemon) => (
          <Card
            key={pokemon.poke_id}
            id={pokemon.poke_id}
            name={pokemon.poke_name}
          />
        ))}
      </div>
    </div>
  );
};

export default PokemonPage;
