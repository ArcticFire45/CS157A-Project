import React from "react";

const Post = ({ author, imageUrl, description, onDelete, currentUser }) => {
  return (
    <div
      style={{
        margin: "10px",
        padding: "10px",
        border: "1px solid #ccc",
        borderRadius: "8px",
        width: "500px",
        position: "relative",
      }}
    >
      <div>
        <span>From: {author}</span>
      </div>
      <div style={{ width: "100%", marginBottom: "10px" }}>
        <img
          src={imageUrl}
          alt="Post"
          style={{ width: "100%", borderRadius: "8px" }}
        />
      </div>
      <p>{description}</p>
      {currentUser === author && (
        <button
          onClick={onDelete}
          style={{
            backgroundColor: "red",
            color: "white",
            padding: "5px 10px",
            borderRadius: "5px",
            border: "none",
          }}
        >
          Delete
        </button>
      )}
    </div>
  );
};

export default Post;
