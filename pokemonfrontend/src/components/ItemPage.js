import React from "react";
import useItems from "../hooks/useItems";
import ItemCard from "./ItemCard";

const ItemPage = () => {
  const items = useItems();

  return (
    <div>
      <h1>Item Page</h1>
      <p>Welcome to the Items Page!</p>
      <div
        style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}
      >
        {items.map((item) => (
          <ItemCard
            key={item.item_id}
            name={item.item_name}
            description={item.item_desc}
            multiplier={item.multiplier}
            imageUrl={item.image_url}
          />
        ))}
      </div>
    </div>
  );
};

export default ItemPage;
