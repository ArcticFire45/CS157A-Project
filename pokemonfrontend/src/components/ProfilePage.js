import React from "react";
import Card from "./Card";
import usePokemons from "../hooks/usePokemons";

const ProfilePage = ({ user, trainerImage, setLoggedIn, setUser }) => {
  const team = usePokemons();

  const handleLogout = () => {
    setUser(null);
    setLoggedIn(false);
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>{user.username}'s Profile</h1>
      <img
        src={trainerImage}
        alt={user.username}
        style={{ width: "200px", borderRadius: "50%" }}
      />
      <h2>Team</h2>
      <div style={{ display: "flex", justifyContent: "center" }}>
        {team.map((pokemon) => (
          <Card
            key={pokemon.poke_id}
            id={pokemon.poke_id}
            name={pokemon.poke_name}
          />
        ))}
      </div>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
};

export default ProfilePage;
