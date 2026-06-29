import { useState } from "react";
import { createUser } from "../services/api";

function UserForm({ refreshUsers }) {

  const [form, setForm] = useState({ email: "", password: "" });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const userData = {
        email: form.email,
        password: form.password,
        username: form.email.split("@")[0]
      };

      await createUser(userData);

      setMessage("✅ User created successfully!");
      setForm({ email: "", password: "" });

      refreshUsers();
    } catch (error) {
      setMessage("❌ Failed to create user. Backend not reachable.");
    }
  };

  return (
    <div className="card">
      <h2>Create Account</h2>

      <form onSubmit={handleSubmit}>
        <input
          name="email"
          placeholder="Enter Email"
          value={form.email}
          onChange={handleChange}
        />

        <input
          name="password"
          placeholder="Enter Password"
          value={form.password}
          onChange={handleChange}
        />

        <button type="submit">Create Account</button>
      </form>

      <p>{message}</p>
    </div>
  );
}

export default UserForm;