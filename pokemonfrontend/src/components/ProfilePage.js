import React, { useState, useEffect } from "react";
import axios from "axios";
import PokemonCard from "./PokemonCard";

const ProfilePage = ({ user, setLoggedIn, setUser, money }) => {
  const [pokemonInventory, setPokemonInventory] = useState([]);
  const [pokemonTeam, setPokemonTeam] = useState([]);

  useEffect(() => {
    const fetchUserInventory = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/getExistingUserPokemon?username=${user.username}`
        );
        setPokemonInventory(response.data);
      } catch (error) {
        console.error("Error fetching user inventory:", error);
      }
    };

    fetchUserInventory();
  }, [user.username, money]);

  useEffect(() => {
    const fetchUserTeam = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/getRoster?username=${user.username}`
        );
        setPokemonTeam(response.data);
      } catch (error) {
        console.error("Error fetching user team:", error);
      }
    };

    fetchUserTeam();
  }, [user.username, pokemonTeam]);

  const handleLogout = () => {
    setUser({ username: "", password: "", money: 0 });
    setLoggedIn(false);
  };

  const handleAddToTeam = async (pokemonID) => {
    try {
      const response = await axios.post(
        `http://localhost:8080/addToRoster?username=${user.username}&pokemonID=${pokemonID}`
      );
      if (response.data) {
        // Assuming the response indicates success
        alert("Pokemon added to team successfully!");
      } else {
        alert("Failed to add Pokemon to team");
      }
    } catch (error) {
      console.error("Error adding Pokemon to team:", error);
    }
  };

  const handleRemoveFromTeam = async (pokemonID) => {
    try {
      const response = await axios.post(
        `http://localhost:8080/deleteFromRoster?username=${user.username}&pokemonID=${pokemonID}`
      );
      if (response.data) {
        // Assuming the response indicates success
        alert("Pokemon removed from team successfully!");
        // Refresh the team after removing a Pokemon
      } else {
        alert("Failed to remove Pokemon from team");
      }
    } catch (error) {
      console.error("Error removing Pokemon from team:", error);
    }
  };

  const teamPokemon = pokemonInventory.filter((pokemon) =>
    pokemonTeam.includes(pokemon.poke_user_id)
  );

  return (
    <div style={{ textAlign: "center" }}>
      <h1>{user.username}'s Profile</h1>
      <button onClick={handleLogout}>Logout</button>
      <h2>Team</h2>
      <div style={{ display: "flex", justifyContent: "center" }}>
        {teamPokemon.map((pokemon) => (
          <div key={pokemon.poke_user_id} style={{ margin: "10px" }}>
            <PokemonCard
              key={pokemon.poke_user_id}
              name={pokemon.poke_name}
              type1={pokemon.type1}
              type2={pokemon.type2}
              imageUrl={pokemon.imageUrl}
              description={pokemon.pokemonDescription}
            />
            <button onClick={() => handleRemoveFromTeam(pokemon.poke_user_id)}>
              Remove Pokemon from Team
            </button>
          </div>
        ))}
      </div>
      <h2>Your Pokemon</h2>
      <div style={{ display: "flex", justifyContent: "center" }}>
        {pokemonInventory.map((pokemon) => (
          <div key={pokemon.poke_user_id} style={{ margin: "10px" }}>
            <PokemonCard
              key={pokemon.poke_user_id}
              name={pokemon.poke_name}
              type1={pokemon.type1}
              type2={pokemon.type2}
              imageUrl={pokemon.imageUrl}
              description={pokemon.pokemonDescription}
            />
            <button onClick={() => handleAddToTeam(pokemon.poke_user_id)}>
              Add to Team
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProfilePage;
