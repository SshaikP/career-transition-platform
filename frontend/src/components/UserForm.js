import { useState } from "react";
import { createUser } from "../services/api";

function UserForm({ refreshUsers }) {

  const [form, setForm] = useState({
    email: "",
    username: "",
    password: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  
const handleSubmit = async (e) => {
  e.preventDefault();

  const userData = {
    email: form.email,
    password: form.password,
    username: form.email.split("@")[0] // ✅ auto-generate
  };

  await createUser(userData);

  setForm({ email: "", username: "", password: "" });

  refreshUsers();
};

  return (
    <div>
      <h2>Create User</h2>

      <form onSubmit={handleSubmit}>
        <input name="email" placeholder="Email" value={form.email} onChange={handleChange} /><br/>
                <input name="password" placeholder="Password" value={form.password} onChange={handleChange} /><br/>
        <button type="submit">Create User</button>
      </form>
    </div>
  );
}

export default UserForm;
