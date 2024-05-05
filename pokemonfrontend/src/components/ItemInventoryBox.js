import React from "react";

const ItemInventoryBox = ({ inventory, totalMultiplier }) => {
  return (
    <div style={{ flex: "1", padding: "20px" }}>
      <h3>Inventory</h3>
      <div
        style={{
          height: "50vh",
          width: "90%",
          overflowY: "auto",
          border: "1px solid #ccc",
          padding: "10px",
        }}
      >
        {inventory.map((item) => (
          <div
            key={item.item_id}
            style={{ display: "flex", justifyContent: "space-between" }}
          >
            <div style={{ flex: "1" }}>{item.item_name}</div>
            <div style={{ flex: "1", textAlign: "right" }}>
              Multiplier: {item.multiplier}
            </div>
          </div>
        ))}
      </div>
      <p>Total Multiplier: {totalMultiplier}</p>
    </div>
  );
};

export default ItemInventoryBox;
