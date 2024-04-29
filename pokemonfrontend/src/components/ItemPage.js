import React from "react";
import Card from "./Card";

const PokemonPage = () => {
    // ADD ITEMS FETCH CALL HERE
  const items = [{item_id: "1", item_name: "Berry Up", item_description: "This will give all your Pokemon +500 pokecoins!"},
  {item_id: "2", item_name: "Money Up", item_description: "Every click will gain an extra +2 pokecoins!"}];

  return (
    <div>
      <h1>Item Page</h1>
      <p>Welcome to the Items Page!</p>
      <div
        style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}
      >
        {items.map((item) => (
          <Card
            key={item.item_id}
            id={item.item_id}
            name={item.item_name}
            description={item.item_description}
          />
        ))}
      </div>
    </div>
  );
};

export default PokemonPage;
