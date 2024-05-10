import React, { useState, useEffect } from "react";
import axios from "axios";
import Post from "./Post";
import UserFriendsBox from "./UserFriendsBox";

const PostsPage = ({ user, money }) => {
  const [newPostImage, setNewPostImage] = useState("");
  const [newPostDescription, setNewPostDescription] = useState("");
  const [makeSale, setMakeSale] = useState(false);
  const [saleType, setSaleType] = useState(""); // State to track sale type
  const [price, setPrice] = useState("");
  const [posts, setPosts] = useState([]);
  const [pokemonInventory, setPokemonInventory] = useState([]);
  const [inventory, setInventory] = useState([]);
  const [selectedPokemon, setSelectedPokemon] = useState();
  const [selectedItem, setSelectedItem] = useState();
  
  console.log(selectedPokemon);

  useEffect(() => {
    const fetchUserInventory = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/getExistingUserPokemon?username=${user.username}`
        );
        setPokemonInventory(response.data);
      } catch (error) {
        console.error("Error fetching user inventory:", error);
      }
    };

    fetchUserInventory();
  }, [user.username, money]);

  useEffect(() => {
    const fetchUserInventory = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/getExistingUserItems?username=${user.username}`
        );
        setInventory(response.data);
      } catch (error) {
        console.error("Error fetching user inventory:", error);
      }
    };

    fetchUserInventory();
  }, [user.username, money]);

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
      let createPostEndpoint;
      let postIdParam;

      const postData = {
        username: user.username,
        postDesc: newPostDescription,
        imageURL: newPostImage,
      };

      if (makeSale) {
        if (saleType === "pokemon") {
          await axios.post(
            `http://localhost:8080/createPokemonSalesPost?username=${
              user.username
            }&postDesc=${newPostDescription}&imageURL=${newPostImage}&price=${parseFloat(
              price
            )}&pokemon_id=${selectedPokemon}`
          );
        } else if (saleType === "item") {
          await axios.post(
            `http://localhost:8080/createItemSalesPost?username=${
              user.username
            }&postDesc=${newPostDescription}&imageURL=${newPostImage}&price=${parseFloat(
              price
            )}&item_id=${selectedItem}`
          );
        }
      } else {
        await axios.post(
          `http://localhost:8080${createPostEndpoint}`,
          postData
        );
      }

      setNewPostDescription("");
      setNewPostImage("");
      setMakeSale(false);
      setPrice("");
      setSaleType(""); // Reset saleType

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
            height: makeSale ? "300px" : "200px", // Adjusted height
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
            rows={4}
          ></textarea>
          <label style={{ marginBottom: "10px" }}>
            <input
              type="checkbox"
              checked={makeSale}
              onChange={(e) => setMakeSale(e.target.checked)}
            />
            Make Sale
          </label>
          {makeSale && (
            <div>
              <label style={{ marginBottom: "10px" }}>
                <input
                  type="radio"
                  name="saleType"
                  value="pokemon"
                  checked={saleType === "pokemon"}
                  onChange={() => setSaleType("pokemon")}
                />
                Pokemon Sale
              </label>
              <label style={{ marginBottom: "10px" }}>
                <input
                  type="radio"
                  name="saleType"
                  value="item"
                  checked={saleType === "item"}
                  onChange={() => setSaleType("item")}
                />
                Item Sale
              </label>
              <input
                type="number"
                placeholder="Price"
                value={price}
                onChange={(e) => setPrice(e.target.value)}
                style={{ marginBottom: "10px", width: "100%", padding: "8px" }}
              />
              {saleType === "pokemon" && (
                <select
                  value={selectedPokemon}
                  onChange={(e) => setSelectedPokemon(e.target.value)}
                  style={{
                    marginBottom: "10px",
                    width: "100%",
                    padding: "8px",
                  }}
                >
                  <option value="">Select a Pokémon</option>
                  {pokemonInventory.map((pokemon) => (
                    <option key={pokemon.poke_id} value={pokemon.poke_id}>
                      {pokemon.poke_name}
                    </option>
                  ))}
                </select>
              )}
              {saleType === "item" && (
                <select
                  value={selectedItem}
                  onChange={(e) => setSelectedItem(e.target.value)}
                  style={{
                    marginBottom: "10px",
                    width: "100%",
                    padding: "8px",
                  }}
                >
                  <option value="">Select an Item</option>
                  {inventory.map((item) => (
                    <option key={item.item_id} value={item.item_id}>
                      {item.item_name}
                    </option>
                  ))}
                </select>
              )}
            </div>
          )}
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

          {posts
            .slice()
            .reverse()
            .map((post) => (
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
