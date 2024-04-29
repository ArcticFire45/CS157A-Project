import React from 'react';

const Card = ({ id, name, description }) => {
  return (
    <div
      style={{
        margin: '10px',
        padding: '10px',
        border: '1px solid #ccc',
        borderRadius: '8px',
        textAlign: 'center',
      }}
    >
      <img
        src={`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png`}
        alt={name}
        style={{ width: '100px', height: '100px' }}
      />
      <p style={{ marginTop: '5px' }}>{name}</p>
      {description && <p>{description}</p>}
    </div>
  );
};

export default Card;
