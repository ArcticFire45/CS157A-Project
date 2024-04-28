import React from "react";
import usePokemons from "../hooks/usePokemons";

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
          <div
            key={pokemon.poke_id}
            style={{
              margin: "10px",
              padding: "10px",
              border: "1px solid #ccc",
              borderRadius: "8px",
              textAlign: "center",
            }}
          >
            <img
              src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemon.poke_id}.png`}
              alt={pokemon.poke_name}
              style={{ width: "100px", height: "100px" }}
            />
            <p style={{ marginTop: "5px" }}>{pokemon.poke_name}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default PokemonPage;
