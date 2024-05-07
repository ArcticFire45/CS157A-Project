import React, { useState, useEffect } from "react";
import axios from "axios";
import Post from "./Post";
import UserFriendsBox from "./UserFriendsBox";

const PostsPage = ({ user }) => {
  const [newPostImage, setNewPostImage] = useState("");
  const [newPostDescription, setNewPostDescription] = useState("");
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await axios.get("http://localhost:8080/allPosts");
        setPosts(response.data);
      } catch (error) {
        console.error("Error fetching posts:", error);
      }
    };

    fetchPosts();
  }, []);

  const handleAddPost = async (e) => {
    e.preventDefault();

    if (!newPostImage || !newPostDescription) {
      alert("Please enter both image URL and description.");
      return;
    }

    try {
      await axios.post("http://localhost:8080/createPost", {
        postDesc: newPostDescription,
        author: user.username,
        imageURL: newPostImage,
      });
      setNewPostDescription("");
      setNewPostImage("");

      const response = await axios.get("http://localhost:8080/allPosts");
      setPosts(response.data);

      alert("Post added!");
    } catch (error) {
      console.error("Error creating post:", error);
    }
  };

  const handleDeletePost = async (postId) => {
    try {
      await axios.delete(
        `http://localhost:8080/deletePost/${postId}/${user.username}`
      );
      const updatedPosts = posts.filter((post) => post.postID !== postId);
      setPosts(updatedPosts);
      alert("Post deleted!");
    } catch (error) {
      console.error("Error deleting post:", error);
    }
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>Home</h1>
      <p>
        Welcome to the Home Page! Scroll down to see all the posts! You can even
        add your own! Don't like your current post? You can also delete it!
      </p>
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
            onChange={(e) => setNewPostImage(e.target.value)}
            style={{ marginBottom: "10px", width: "100%", padding: "8px" }}
          />
          <textarea
            placeholder="Description"
            value={newPostDescription}
            onChange={(e) => setNewPostDescription(e.target.value)}
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
              key={post.postID}
              author={post.author}
              imageUrl={post.imageURL}
              description={post.postDesc}
              onDelete={() => handleDeletePost(post.postID)}
              currentUser={user.username}
            />
          ))}
        </div>
      </div>
      <UserFriendsBox user={user} />
    </div>
  );
};

export default PostsPage;
