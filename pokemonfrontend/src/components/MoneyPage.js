import React, { useState } from "react";
import axios from "axios";
import ItemInventoryBox from "./ItemInventoryBox";

const MoneyPage = ({ money, setMoney, user }) => {
  const [clicked, setClicked] = useState(false);
  // const [inventory, setInventory] = useState([]);

  // useEffect(() => {
  //   // Fetch user's inventory from the server
  //   fetchUserInventory();
  // }, []);

  // const fetchUserInventory = async () => {
  //   try {
  //     const response = await axios.get(`http://localhost:8080/userInventory/${user.username}`);
  //     setInventory(response.data.inventory);
  //   } catch (error) {
  //     console.error("Error fetching user inventory:", error);
  //   }
  // };
  const inventory = [
    { item_id: 1, item_name: "Bombs", multiplier: 10 },
    {
      item_id: 2,
      item_name: "Anti-Pikachu-Rubber-Balloon-Bazooka",
      multiplier: 5,
    },
    { item_id: 3, item_name: "Foo", multiplier: 5 },
    { item_id: 4, item_name: "Foo", multiplier: 5 },
    { item_id: 5, item_name: "Foo", multiplier: 5 },
    { item_id: 6, item_name: "Foo", multiplier: 5 },
    { item_id: 7, item_name: "Foo", multiplier: 5 },
    { item_id: 8, item_name: "Foo", multiplier: 5 },
    { item_id: 9, item_name: "Foo", multiplier: 5 },
    { item_id: 10, item_name: "Foo", multiplier: 5 },
    { item_id: 11, item_name: "Foo", multiplier: 5 },
    { item_id: 12, item_name: "Foo", multiplier: 5 },
    { item_id: 13, item_name: "Foo", multiplier: 5 },
  ];

  const totalMultiplier = inventory.reduce(
    (acc, item) => acc + item.multiplier,
    1
  );

  const handleClick = async () => {
    const randomMoney = Math.floor(Math.random() * 6) + 1 * totalMultiplier;
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
        display: "flex",
        flexDirection: "row",
      }}
    >
      <div
        style={{
          flex: "1",
          padding: "20px",
        }}
      >
        <ItemInventoryBox
          inventory={inventory}
          totalMultiplier={totalMultiplier}
        />
      </div>
      <div
        style={{
          flex: "3",
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
    </div>
  );
};

export default MoneyPage;
