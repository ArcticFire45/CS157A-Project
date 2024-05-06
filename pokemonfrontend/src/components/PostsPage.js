import React, { useState, useEffect } from "react";
import axios from "axios";
import Post from "./Post";

const PostsPage = () => {
  const [newPostImage, setNewPostImage] = useState("");
  const [newPostDescription, setNewPostDescription] = useState("");
  const [posts, setPosts] = useState([
    {
      id: 1,
      imageUrl: "https://via.placeholder.com/300",
      description: "This is the first post",
    },
    {
      id: 2,
      imageUrl: "https://via.placeholder.com/300",
      description: "This is the second post",
    },
    {
      id: 3,
      imageUrl: "https://via.placeholder.com/300",
      description: "This is the third post",
    },
  ]);
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

  const handleImageChange = (event) => {
    setNewPostImage(event.target.value);
  };

  const handleDescriptionChange = (event) => {
    setNewPostDescription(event.target.value);
  };

  const handleAddPost = () => {
    const newPost = {
      id: posts.length + 1,
      imageUrl: newPostImage,
      description: newPostDescription,
    };
    setPosts([...posts, newPost]);

    setNewPostImage("");
    setNewPostDescription("");
  };

  const handleAddFriend = (username) => {
    // Add logic to add friend
    alert(`Friend request sent to ${username}`);
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Home</h1>
      <div style={{ marginBottom: "20px" }}>
        <h2>Add New Post</h2>
        <div
          style={{
            border: "2px solid #ccc",
            borderRadius: "10px",
            padding: "20px",
            marginBottom: "10px",
            width: "50vw",
            height: "200px",
            marginLeft: "25vw",
            position: "relative",
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <input
            type="text"
            placeholder="Image URL"
            value={newPostImage}
            onChange={handleImageChange}
            style={{ marginBottom: "10px", width: "100%", padding: "8px" }}
          />
          <textarea
            placeholder="Description"
            value={newPostDescription}
            onChange={handleDescriptionChange}
            style={{ marginBottom: "10px", width: "100%", padding: "8px" }}
            rows={6}
          ></textarea>
          <button
            onClick={handleAddPost}
            style={{
              padding: "10px 20px",
              fontSize: "16px",
              position: "absolute",
              bottom: 10,
              right: 10,
            }}
          >
            Add Post
          </button>
        </div>
      </div>
      <div style={{ width: "100%", display: "flex", justifyContent: "center" }}>
        <div>
          <h2>Posts</h2>

          {posts.map((post) => (
            <Post
              key={post.id}
              imageUrl={post.imageUrl}
              description={post.description}
            />
          ))}
        </div>
      </div>
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
    </div>
  );
};

export default PostsPage;
