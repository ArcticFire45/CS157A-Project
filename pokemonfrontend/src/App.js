import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import MoneyPage from "./components/MoneyPage";
import ShopPage from "./components/ShopPage";
import ProfilePage from "./components/ProfilePage";
import PokemonPage from "./components/PokemonPage";
import ItemPage from "./components/ItemPage";
import "./App.css";
import PostsPage from "./components/PostsPage";
import usePokemons from "./hooks/usePokemons";
import SignupForm from "./components/Signup";

const App = () => {
  const [money, setMoney] = useState(0);

  return (
    <Router>
      <>
        <Navbar />
        <Routes>
          <Route
            path="/"
            element={<PostsPage />}
          />
          <Route path="/money" element={<MoneyPage money={money} setMoney={setMoney} />} />
          <Route path="/pokemon" element={<PokemonPage />} />
          <Route path="/signup" element={<SignupForm />} />
          <Route path="/shop" element={<ShopPage />} />
          <Route path="/profile" element={<ProfilePage trainerName="Kevin" trainerImage="https://via.placeholder.com/300" team={usePokemons()}/>} />
          <Route path="/items" element={<ItemPage />} />
        </Routes>
      </>
    </Router>
  );
};

export default App;
