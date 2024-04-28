import React from 'react';
import Post from './Post';

const PostsPage = () => {
  const posts = [
    { id: 1, imageUrl: 'https://via.placeholder.com/300', description: 'This is the first post' },
    { id: 2, imageUrl: 'https://via.placeholder.com/300', description: 'This is the second post' },
    { id: 3, imageUrl: 'https://via.placeholder.com/300', description: 'This is the third post' },
  ];

  return (
    <div style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}>
        <div style={{
          position: "fixed",
          top: "10%",
          left: "50%",
          transform: "translateX(-50%)",
          textAlign: "center",
        }}>
      <h1>Posts</h1>
      <p>Welcome to the Home Page!</p>
      <div>
        {posts.map(post => (
          <Post
            key={post.id}
            imageUrl={post.imageUrl}
            description={post.description}
          />
        ))}
      </div>
      </div>
    </div>
  );
};

export default PostsPage;
