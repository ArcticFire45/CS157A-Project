import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import HomePage from "./components/HomePage";
import ShopPage from "./components/ShopPage";
import ProfilePage from "./components/ProfilePage";
import PokemonPage from "./components/PokemonPage";
import "./App.css";

const App = () => {
  const [money, setMoney] = useState(0);

  return (
    <Router>
      <>
        <Navbar />
        <Routes>
          <Route
            path="/"
            element={<HomePage money={money} setMoney={setMoney} />}
          />
          <Route path="/pokemon" element={<PokemonPage />} />
          <Route path="/shop" element={<ShopPage />} />
          <Route path="/profile" element={<ProfilePage />} />
        </Routes>
      </>
    </Router>
  );
};

export default App;
