import { Link } from "react-router-dom";

function Home() {
  return (
    <div style={{ textAlign: "center", marginTop: "100px" }}>
      <h1>Event Management System</h1>
      <Link to="/admin-login">
        <button>Admin Login</button>
      </Link>
      <br /><br />
      <Link to="/user-login">
        <button>User Login</button>
      </Link>
    </div>
  );
}

export default Home;
