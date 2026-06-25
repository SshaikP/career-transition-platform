import { useState } from "react";

function AdminPanel() {

  const [role, setRole] = useState("");
  const [skill, setSkill] = useState("");

  const token = localStorage.getItem("token");

  const addRole = async () => {
    await fetch("/api/admin/role", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      },
      body: JSON.stringify({ name: role })
    });
    alert("Role added ✅");
  };

  const addSkill = async () => {
    await fetch("/api/admin/role-skill", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      },
      body: JSON.stringify({ role, skill })
    });
    alert("Skill added ✅");
  };

  return (
    <div className="card">

      <h2>⚙️ Admin Panel</h2>

      <input
        placeholder="Role"
        onChange={(e) => setRole(e.target.value)}
      />
      <button onClick={addRole}>Add Role</button>

      <br /><br />

      <input
        placeholder="Skill"
        onChange={(e) => setSkill(e.target.value)}
      />
      <button onClick={addSkill}>Add Skill</button>

    </div>
  );
}

export default AdminPanel;
