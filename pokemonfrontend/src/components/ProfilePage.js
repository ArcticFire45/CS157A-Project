import React from 'react';
import Card from './Card';
import usePokemons from '../hooks/usePokemons';

const ProfilePage = ({ trainerName, trainerImage }) => {
  const team = usePokemons();
  return (
    <div style={{ textAlign: 'center' }}>
      <h1>{trainerName}'s Profile</h1>
      <img src={trainerImage} alt={trainerName} style={{ width: '200px', borderRadius: '50%' }} />
      <h2>Team</h2>
      <div style={{ display: 'flex', justifyContent: 'center' }}>
        {team.map((pokemon) => (
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

export default ProfilePage;
