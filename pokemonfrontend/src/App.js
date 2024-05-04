import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Navbar from "./components/Navbar";
import MoneyPage from "./components/MoneyPage";
import ShopPage from "./components/ShopPage";
import ProfilePage from "./components/ProfilePage";
import PokemonPage from "./components/PokemonPage";
import ItemPage from "./components/ItemPage";
import "./App.css";
import PostsPage from "./components/PostsPage";
import SignupForm from "./components/Signup";
import LoginPage from "./components/LoginPage";

const App = () => {
  const [money, setMoney] = useState(0);
  const [user, setUser] = useState({username: "", password: "", money: 0});
  const [loggedIn, setLoggedIn] = useState(false);

  return (
    <Router>
      <>
        <Navbar />
        <Routes>
        <Route
            path="/"
            element={loggedIn ? <PostsPage /> : <Navigate to="/login" />}
          />
          <Route 
            path="/money" 
            element={loggedIn ? <MoneyPage money={money} setMoney={setMoney} /> : <Navigate to="/login" />} 
          />
          <Route 
            path="/pokemon" 
            element={loggedIn ? <PokemonPage /> : <Navigate to="/login" />} 
          />
          <Route path="/signup" element={<SignupForm />} />
          <Route path="/login" element={<LoginPage setLoggedIn={setLoggedIn} setUser={setUser} />} />
          <Route path="/shop" element={loggedIn ? <ShopPage /> : <Navigate to="/login" />} />
          <Route path="/profile" element={loggedIn ? <ProfilePage trainerName="Kevin" trainerImage="https://via.placeholder.com/300" /> : <Navigate to="/login" />} />
          <Route path="/items" element={loggedIn ? <ItemPage /> : <Navigate to="/login" />} />
        </Routes>
      </>
    </Router>
  );
};

export default App;
