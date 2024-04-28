import React, { useEffect, useState } from "react";
import axios from "axios";

const usePokemons = () => {
  const [pokemons, setPokemons] = useState([]);

  useEffect(() => {
    loadPokemon();
  }, []);

  const loadPokemon = async () => {
    const result = await axios.get("http://localhost:8080/pokepoke");
    setPokemons(result.data);
  };

  return pokemons;
};

export default usePokemons;
