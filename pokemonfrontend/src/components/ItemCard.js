import React, { useState } from "react";

const ItemCard = ({ name, description, multiplier, imageUrl }) => {
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
          <p style={{ fontWeight: "bold", color: "#007bff" }}>
            Increases your clicking power by: {multiplier}
          </p>
        </div>
      ) : (
        <div>
          <p>{name}</p>
          <img
            src={imageUrl}
            alt={name}
            style={{ width: "100px", height: "100px" }}
          />
        </div>
      )}
    </div>
  );
};

export default ItemCard;
