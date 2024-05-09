import React, { useState, useEffect } from "react";
import axios from "axios";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
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
  const [user, setUser] = useState(() => {
    const storedUser = localStorage.getItem("user");
    return storedUser
      ? JSON.parse(storedUser)
      : { username: "", password: "", money: 0 };
  });
  const [loggedIn, setLoggedIn] = useState(() => {
    const storedLoggedIn = localStorage.getItem("loggedIn");
    return storedLoggedIn ? JSON.parse(storedLoggedIn) : false;
  });
  const [money, setMoney] = useState(user.money || 0.0);

  useEffect(() => {
    localStorage.setItem("user", JSON.stringify(user));
  }, [user]);

  useEffect(() => {
    localStorage.setItem("loggedIn", JSON.stringify(loggedIn));
  }, [loggedIn]);

  useEffect(() => {
    const fetchUserMoney = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/user?username=${user.username}`
        );
        setMoney(response.data.money);
      } catch (error) {
        console.error("Error fetching user money:", error);
      }
    };

    fetchUserMoney();
  }, [user.username, money]);

  return (
    <Router>
      <>
        <Navbar />
        <Routes>
          <Route
            path="/"
            element={
              loggedIn ? <PostsPage user={user} /> : <Navigate to="/login" />
            }
          />
          <Route
            path="/money"
            element={
              loggedIn ? (
                <MoneyPage money={money} setMoney={setMoney} user={user} />
              ) : (
                <Navigate to="/login" />
              )
            }
          />
          <Route
            path="/pokemon"
            element={
              loggedIn ? <PokemonPage user={user} /> : <Navigate to="/login" />
            }
          />
          <Route
            path="/signup"
            element={<SignupForm setLoggedIn={setLoggedIn} setUser={setUser} />}
          />
          <Route
            path="/login"
            element={<LoginPage setLoggedIn={setLoggedIn} setUser={setUser} />}
          />
          <Route
            path="/shop"
            element={loggedIn ? <ShopPage /> : <Navigate to="/login" />}
          />
          <Route
            path="/profile"
            element={
              loggedIn ? (
                <ProfilePage
                  user={user}
                  trainerImage="https://via.placeholder.com/300"
                  setLoggedIn={setLoggedIn}
                  setUser={setUser}
                  money={money}
                />
              ) : (
                <Navigate to="/login" />
              )
            }
          />
          <Route
            path="/items"
            element={
              loggedIn ? <ItemPage user={user} /> : <Navigate to="/login" />
            }
          />
        </Routes>
      </>
    </Router>
  );
};

export default App;
