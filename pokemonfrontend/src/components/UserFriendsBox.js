import React, { useState, useEffect } from "react";
import axios from "axios";

const UserFriendsBox = ({user}) => {
    const [usernames, setUsernames] = useState([]);

    useEffect(() => {
      const fetchUsernames = async () => {
        try {
          const response = await axios.get("http://localhost:8080/alluser");
          setUsernames(response.data);
        } catch (error) {
          console.error("Error fetching usernames:", error);
        }
      };
  
      fetchUsernames();
    }, []);

    const handleAddFriend = async (friendUserName) => {
        try {
            await axios.post("http://localhost:8080/addFriend", {
                username1: user.username,
                username2: friendUserName,
              });
            alert(`Friend request sent to ${friendUserName}`);
          } catch (error) {
            console.error("Error adding friend:", error);
          }
      };
    
  return (
    <div
      style={{
        width: "200px",
        position: "fixed",
        top: "200px",
        right: "0",
        border: "1px solid #ccc",
        padding: "20px",
        height: "50vh",
        overflowY: "auto",
      }}
    >
      <h2>All Users</h2>
      <div style={{ textAlign: "left" }}>
        {usernames.map((username) => (
          <div
            key={username}
            style={{
              marginBottom: "10px",
              position: "relative",
              backgroundColor: "#e0e0e0",
              borderRadius: "5px",
            }}
          >
            <div
              style={{
                padding: "8px",
                marginRight: "40px",
              }}
            >
              {username}
            </div>
            <button
              onClick={() => handleAddFriend(username)}
              style={{
                borderRadius: "20px",
                padding: "5px 15px",
                fontSize: "12px",
                position: "absolute",
                top: "50%",
                transform: "translateY(-50%)",
                right: "10px",
              }}
            >
              Add Friend
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default UserFriendsBox;
