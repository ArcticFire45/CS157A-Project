import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";

const SignupForm = ({ setLoggedIn, setUser }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [signupStatus, setSignupStatus] = useState("");
  const navigate = useNavigate();

  const handleSignup = async (e) => {
    e.preventDefault();
    if (!username || !password) {
      setSignupStatus("Please enter both username and password");
      return;
    }

    const response = await axios.post("http://localhost:8080/signup", {
      username: username,
      password: password,
      money: 0,
    });

    if (response.data === 0) {
      setSignupStatus("Username has already been used!");
    } else if (response.data === 1) {
      setSignupStatus("Successfully Signed Up!");
      setLoggedIn(true);
      setUser({ username: username, password: password, money: 0 });
    } else {
      setSignupStatus("Action Failed");
    }
  };

  useEffect(() => {
    let timeout;
    if (signupStatus === "Successfully Signed Up!") {
      timeout = setTimeout(() => {
        navigate("/");
      }, 1000);
    }
    return () => clearTimeout(timeout);
  }, [signupStatus, navigate]);

  return (
    <div
      style={{
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <h2>Sign Up</h2>
      <p>Welcome to Pokemon!</p>
      <form
        style={{
          width: "300px",
          marginBottom: "20px",
        }}
        onSubmit={handleSignup}
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
      {signupStatus && <p>{signupStatus}</p>}
      <p>
        Already have an account? <Link to="/login">Login</Link>
      </p>
    </div>
  );
};

export default SignupForm;
