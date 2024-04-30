import React from "react";
import useItems from "../hooks/useItems";
import Card from "./Card";

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
          <Card
            key={item.item_id}
            id={item.item_id}
            name={item.item_name}
            description={item.item_desc}
          />
        ))}
      </div>
    </div>
  );
};

export default ItemPage;
