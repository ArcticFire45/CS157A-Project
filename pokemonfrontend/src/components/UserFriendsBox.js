import React, { useState, useEffect } from "react";
import axios from "axios";

const UserFriendsBox = ({ user }) => {
  const [usernames, setUsernames] = useState([]);
  const [friendStatuses, setFriendStatuses] = useState({});

  useEffect(() => {
    const fetchUsernames = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/alluser/${user.username}`
        );
        setUsernames(response.data);
      } catch (error) {
        console.error("Error fetching usernames:", error);
      }
    };

    fetchUsernames();
  }, [user.username]);

  useEffect(() => {
    const fetchFriendStatuses = async () => {
      try {
        const newFriendStatuses = {};
        for (const username of usernames) {
          const response = await axios.get(
            `http://localhost:8080/checkFriendship?username1=${user.username}&username2=${username}`
          );
          newFriendStatuses[username] = response.data;
        }
        setFriendStatuses(newFriendStatuses);
      } catch (error) {
        console.error("Error checking friendships:", error);
      }
    };

    fetchFriendStatuses();
  }, [user.username, usernames, friendStatuses]);

  const handleAddFriend = async (friendUserName) => {
    try {
      await axios.post("http://localhost:8080/addFriend", {
        username1: user.username,
        username2: friendUserName,
      });
      alert(`${friendUserName} has been added as a friend`);
    } catch (error) {
      console.error("Error adding/deleting friend:", error);
    }
  };

  const handleDeleteFriend = async (friendUserName) => {
    try {
      await axios.delete("http://localhost:8080/removeFriend", {
        data: {
          username1: user.username,
          username2: friendUserName,
        },
      });
      alert(`Friend ${friendUserName} removed`);
    } catch (error) {
      console.error("Error adding/deleting friend:", error);
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
        borderTopLeftRadius: "10px",
        borderBottomLeftRadius: "10px",
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
            {friendStatuses[username] ? (
              <button
                onClick={() => handleDeleteFriend(username)}
                style={{
                  borderRadius: "20px",
                  padding: "5px 15px",
                  fontSize: "12px",
                  position: "absolute",
                  top: "50%",
                  transform: "translateY(-50%)",
                  right: "10px",
                  backgroundColor: "red",
                  color: "#fff",
                }}
              >
                Remove Friend
              </button>
            ) : (
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
                  backgroundColor: "#036bfc",
                  color: "#fff",
                }}
              >
                Add Friend
              </button>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};

export default UserFriendsBox;
