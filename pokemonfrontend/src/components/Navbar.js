import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar">
      <Link
        to="/"
        style={{
          color: "white",
          textDecoration: "none",
          fontSize: "20px",
          display: "flex",
          alignItems: "center",
        }}
      >
        PokeHome
      </Link>
      <ul className="navbar-nav">
      <li className="nav-item">
          <Link to="/money" className="nav-link">
            Money
          </Link>
        </li>
      <li className="nav-item">
          <Link to="/items" className="nav-link">
            Items
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/pokemon" className="nav-link">
            Pokemon
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/shop" className="nav-link">
            Shop
          </Link>
        </li>
        <li className="nav-item">
          <Link to="/profile" className="nav-link">
            Profile
          </Link>
        </li>
      </ul>
    </nav>
  );
}

export default Navbar;
