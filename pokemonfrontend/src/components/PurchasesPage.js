import React, { useState, useEffect } from "react";
import axios from "axios";

const PurchasesPage = ({ user }) => {
  const [purchases, setPurchases] = useState([]);

  useEffect(() => {
    const fetchUserPurchases = async () => {
      try {
        const response = await axios.post(
          `http://localhost:8080/getUserPurchases?username=${user.username}`);
        setPurchases(response.data);
      } catch (error) {
        console.error("Error fetching user purchases:", error);
      }
    };

    fetchUserPurchases();
  }, [user.username]);

  return (
    <div style={{ textAlign: "center" }}>
      <h1>User Purchases</h1>
      <div style={{ display: "flex", justifyContent: "center", flexWrap: "wrap" }}>
        {purchases.map((purchase) => (
          <div
            key={purchase.sales_id}
            style={{
              border: "1px solid #ccc",
              borderRadius: "5px",
              padding: "10px",
              marginBottom: "20px",
              marginRight: "20px",
              width: "250px",
            }}
          >
            <p>Sales ID: {purchase.sales_id}</p>
            <p>Seller: The Shop</p>
            <p>Price: ${purchase.price.toFixed(2)}</p>
          </div>
        ))}
      </div>
    </div>
  );

};

export default PurchasesPage;