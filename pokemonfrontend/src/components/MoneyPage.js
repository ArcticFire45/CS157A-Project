import React, { useState } from "react";
import axios from "axios";

const MoneyPage = ({ money, setMoney, user }) => {
  const [clicked, setClicked] = useState(false);

  const handleClick = async () => {
    const randomMoney = Math.floor(Math.random() * 5) + 1;
    const newMoney = money + randomMoney;
    setMoney(newMoney);
    setClicked(true);

    try {
      await axios.post("http://localhost:8080/updateMoney", {
        username: user.username,
        moneyToAdd: randomMoney,
      });
    } catch (error) {
      console.error("Error updating user money:", error);
    }

    setTimeout(() => {
      setClicked(false);
    }, 75);
  };

  return (
    <div
      style={{
        position: "relative",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        height: "70vh",
      }}
    >
      <div
        style={{
          position: "fixed",
          top: "10%",
          left: "50%",
          transform: "translateX(-50%)",
          textAlign: "center",
        }}
      >
        <h1>Money Page</h1>
        <p>Welcome to the Money Page!</p>
        <p>Click on Meowth to get Money!</p>
        <div>
          <img
            src="https://64.media.tumblr.com/c3f6563dc4cbbf9fa5cbdc6c85346529/tumblr_inline_pab3jajU1d1qapklj_500.png"
            alt="Click Me"
            style={{
              cursor: "pointer",
              width: clicked ? "310px" : "300px",
              height: clicked ? "310px" : "300px",
              transition: "all 0.1s ease-in-out",
            }}
            onClick={handleClick}
          />
        </div>
      </div>
      <div
        style={{
          position: "absolute",
          top: "10px",
          right: "10px",
        }}
      >
        <p>Money: {money}</p>
      </div>
    </div>
  );
};

export default MoneyPage;
