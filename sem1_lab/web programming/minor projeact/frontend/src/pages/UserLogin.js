import { useNavigate } from "react-router-dom";

function UserLogin() {
  const navigate = useNavigate();

  const handleLogin = () => {
    navigate("/user-dashboard");
  };

  return (
    <div style={{ textAlign: "center", marginTop: "100px" }}>
      <h2>User Login</h2>
      <input type="email" placeholder="Email" /><br /><br />
      <input type="password" placeholder="Password" /><br /><br />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default UserLogin;
