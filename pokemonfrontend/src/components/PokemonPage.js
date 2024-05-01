import React, { useState } from "react";
import axios from "axios";
import usePokemons from "../hooks/usePokemons";
import PokemonCard from "./PokemonCard";

const PokemonPage = () => {
  const pokemons = usePokemons();
  const [searchTerm, setSearchTerm] = useState("");
  const [filteredPokemons, setFilteredPokemons] = useState(pokemons);
  const [useGif, setUseGif] = useState(false);

  const handleSearchChange = async (event) => {
    const { value } = event.target;
    setSearchTerm(value);
    if (value.trim() === "") {
      setFilteredPokemons([]);
      return;
    }
    try {
      const response = await axios.get(
        `http://localhost:8080/search?name=${value}`
      );
      setFilteredPokemons(response.data);
    } catch (error) {
      console.error("Error searching Pokémon:", error);
    }
  };

  const toggleImageType = () => {
    setUseGif((prevUseGif) => !prevUseGif);
  };

  return (
    <div>
      <div style={{ textAlign: "center" }}>
        <div style={{ position: "absolute", top: "100px", right: "10px" }}>
          <select onChange={toggleImageType} value={useGif ? "gif" : "image"}>
            <option value="image">Use Image</option>
            <option value="gif">Use GIF</option>
          </select>
        </div>
        <h1>Pokedex</h1>
        <p>Welcome to the Pokemon Page!</p>
        <p>
          Click on any card below to see a better description of the pokemon!
        </p>
        <input
          type="text"
          placeholder="Search Pokemon..."
          value={searchTerm}
          onChange={handleSearchChange}
          style={{ marginBottom: "15px", fontSize: "20px" }}
        />
      </div>
      <div
        style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}
      >
        {filteredPokemons.length > 0
          ? filteredPokemons.map((pokemon) => (
              <PokemonCard
                key={pokemon.poke_id}
                name={pokemon.poke_name}
                type1={pokemon.type1}
                type2={pokemon.type2}
                imageUrl={useGif ? pokemon.gifUrl : pokemon.imageUrl}
                description={pokemon.pokemonDescription}
              />
            ))
          : pokemons.map((pokemon) => (
              <PokemonCard
                key={pokemon.poke_id}
                name={pokemon.poke_name}
                type1={pokemon.type1}
                type2={pokemon.type2}
                imageUrl={useGif ? pokemon.gifUrl : pokemon.imageUrl}
                description={pokemon.pokemonDescription}
              />
            ))}
      </div>
    </div>
  );
};

export default PokemonPage;
