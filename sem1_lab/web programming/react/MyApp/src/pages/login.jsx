export default function Login() {
  return (
    <div>
      <h1>Login Page</h1>

      <form style={{ maxWidth: "300px", marginTop: "20px" }}>
        <label>Email:</label>
        <input type="email" placeholder="Enter email" required /><br /><br />

        <label>Password:</label>
        <input type="password" placeholder="Enter password" required /><br /><br />

        <button>Login</button>
      </form>
    </div>
  );
}
