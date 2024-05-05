import React, { useState } from "react";
import axios from "axios";
import useItems from "../hooks/useItems";
import ItemCard from "./ItemCard";

const ItemPage = () => {
  const items = useItems();
  const [searchTerm, setSearchTerm] = useState("");
  const [filteredItems, setFilteredItems] = useState(items);

  const handleSearchChange = async (event) => {
    const { value } = event.target;
    setSearchTerm(value);
    if (value.trim() === "") {
      setFilteredItems([]);
      return;
    }
    try {
      const response = await axios.get(
        `http://localhost:8080/itemsearch?name=${value}`
      );
      setFilteredItems(response.data);
    } catch (error) {
      console.error("Error searching Pokémon:", error);
    }
  };

  const handleBuy = () => {
    // Implement your buy functionality here
  };

  return (
    <div style={{ textAlign: "center", marginBottom: "50px" }}>
      <h1>Item Page</h1>
      <p>Welcome to the Items Page!</p>
      <p>Click on any card below to see a better description of the item!</p>
      <input
        type="text"
        placeholder="Search Items..."
        value={searchTerm}
        onChange={handleSearchChange}
        style={{ marginBottom: "15px", fontSize: "20px" }}
      />
      <div
        style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}
      >
        {filteredItems.length > 0
          ? filteredItems.map((item) => (
              <div key={item.item_id} style={{ margin: "10px" }}>
                <ItemCard
                  name={item.item_name}
                  description={item.item_desc}
                  multiplier={item.multiplier}
                  imageUrl={item.image_url}
                />
                <div
                  style={{
                    display: "flex",
                    alignItems: "center",
                    marginTop: "10px",
                    border: "1px solid #ccc",
                    borderRadius: "8px",
                    padding: "5px 10px",
                  }}
                >
                  <button onClick={handleBuy} style={{ marginRight: "10px" }}>
                    Buy
                  </button>
                  <p style={{ marginLeft: "10px" }}>Price: {item.stockPrice}</p>
                </div>
              </div>
            ))
          : items.map((item) => (
              <div key={item.item_id} style={{ margin: "10px" }}>
                <ItemCard
                  name={item.item_name}
                  description={item.item_desc}
                  multiplier={item.multiplier}
                  imageUrl={item.image_url}
                />
                <div
                  style={{
                    display: "flex",
                    alignItems: "center",
                    marginTop: "10px",
                    border: "1px solid #ccc",
                    borderRadius: "8px",
                    padding: "5px 10px",
                  }}
                >
                  <button onClick={handleBuy} style={{ marginRight: "10px" }}>
                    Buy
                  </button>
                  <p style={{ marginLeft: "10px" }}>Price: {item.stockPrice}</p>
                </div>
              </div>
            ))}
      </div>
    </div>
  );
};

export default ItemPage;
