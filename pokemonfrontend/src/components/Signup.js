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
    <div>
      <h2>Signup</h2>
      <input
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button onClick={handleSignup}>Signup</button>
      {signupStatus && <p>{signupStatus}</p>}
      <p>
        Already have an account? <Link to="/login">Login</Link>
      </p>
    </div>
  );
};

export default SignupForm;
