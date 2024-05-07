import React, { useState } from "react";

const PokemonCard = ({ name, type1, type2, imageUrl, description }) => {
  const [showDescription, setShowDescription] = useState(false);

  const toggleDescription = () => {
    setShowDescription(!showDescription);
  };

  return (
    <div
      style={{
        margin: "10px",
        padding: "10px",
        border: "1px solid #ccc",
        borderRadius: "8px",
        textAlign: "center",
        cursor: "pointer",
        width: "150px",
        height: "225px",
      }}
      onClick={toggleDescription}
    >
      {showDescription ? (
        <div>
          <p>{description}</p>
        </div>
      ) : (
        <div>
          <p>{name}</p>
          <img
            src={imageUrl}
            alt={name}
            style={{ width: "100px", height: "100px" }}
          />
          <div style={{ display: "flex", justifyContent: "center" }}>
            <div
              style={{
                backgroundColor: "#f0f0f0",
                padding: "5px 10px",
                borderRadius: "20px",
                margin: "5px",
              }}
            >
              {type1}
            </div>
            {type2 && (
              <div
                style={{
                  backgroundColor: "#f0f0f0",
                  padding: "5px 10px",
                  borderRadius: "20px",
                  margin: "5px",
                }}
              >
                {type2}
              </div>
            )}
          </div>
        </div>
      )}
    </div>
  );
};

export default PokemonCard;
