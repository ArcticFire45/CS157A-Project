import React, { useState } from "react";
import Post from "./Post";
import UserFriendsBox from "./UserFriendsBox";

const PostsPage = ({ user }) => {
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
      <UserFriendsBox user={user} />
    </div>
  );
};

export default PostsPage;
