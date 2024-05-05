import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

function LoginPage({ setLoggedIn, setUser }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loginStatus, setLoginStatus] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!username || !password) {
      setLoginStatus("Please enter both username and password");
      return;
    }

    try {
      const response = await axios.get(
        `http://localhost:8080/login/${username}/${password}`
      );
      if (response.status === 200) {
        setLoginStatus("Login successful");
        setLoggedIn(true);
        setUser(response.data);
      } else {
        setLoginStatus("Invalid username or password");
      }
    } catch (error) {
      console.error("Error logging in:", error);
      setLoginStatus("Invalid username or password");
    }
  };

  useEffect(() => {
    let timeout;
    if (loginStatus === "Login successful") {
      timeout = setTimeout(() => {
        navigate("/");
      }, 1000);
    }
    return () => clearTimeout(timeout);
  }, [loginStatus, navigate]);

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <h2>Log In</h2>
      <p>Please login below!</p>
      <form
        style={{
          width: "300px",
          marginBottom: "20px",
        }}
        onSubmit={handleSubmit}
      >
        <div style={{ marginBottom: "10px" }}>
          <label>Username:</label>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            style={{ width: "100%" }}
          />
        </div>
        <div style={{ marginBottom: "30px" }}>
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            style={{ width: "100%" }}
          />
        </div>
        <button type="submit" style={{ width: "100%" }}>
          Login
        </button>
      </form>
      {loginStatus && <p>{loginStatus}</p>}
      <p>
        Don't have an account? <Link to="/signup">Make new account</Link>
      </p>
    </div>
  );
}

export default LoginPage;
