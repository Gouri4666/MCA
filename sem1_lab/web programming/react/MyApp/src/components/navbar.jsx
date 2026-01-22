import React from "react";
import { NavLink } from "react-router-dom";

const Navbar = () => {
  const linkStyle = {
    marginRight: "20px",
    textDecoration: "none",
    fontSize: "18px",
  };

  return (
    <nav
      style={{
        padding: "10px",
        backgroundColor: "#222",
        color: "white",
      }}
    >
      <NavLink to="/" style={linkStyle}>
        Home
      </NavLink>

      <NavLink to="/about" style={linkStyle}>
        About
      </NavLink>

      <NavLink to="/login" style={linkStyle}>
        Login
      </NavLink>
    </nav>
  );
};

export default Navbar;
