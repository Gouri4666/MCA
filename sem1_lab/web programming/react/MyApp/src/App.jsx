// src/App.jsx
import React from "react";
import Counter from "./counter";
import "./App.css";

function App() {
  // Show only your StudentList page (no extra default template)
  return (
    <div className="app-root">
      <Counter />
    </div>
  );
}

export default App;
