import React from "react";
import PurchasesPage from "./PurchasesPage";

const ShopPage = ({ user }) => {
  return (
    <div style={{ textAlign: "center" }}>
      <h1>Shop Page</h1>
      <p>Welcome to the Shop!</p>
      <PurchasesPage user={user}/>
    </div>
  );
};

export default ShopPage;