import React from "react";
import usePokemons from "../hooks/usePokemons";
import PokemonCard from "./PokemonCard";

const PokemonPage = () => {
  const pokemons = usePokemons();

  return (
    <div>
      <div style={{ textAlign: "center" }}>
        <h1>Pokedex</h1>
        <p>Welcome to the Pokemon Page!</p>
        <p>Click on any card below to see a better description of the pokemon!</p>
      </div>
      <div style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}>
        {pokemons.map((pokemon) => (
          <PokemonCard
            key={pokemon.poke_id}
            name={pokemon.poke_name}
            type1={pokemon.type1}
            type2={pokemon.type2}
            imageUrl={pokemon.imageUrl}
            description={pokemon.pokemonDescription}
          />
        ))}
      </div>
    </div>
  );
};

export default PokemonPage;