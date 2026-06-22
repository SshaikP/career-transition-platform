import { useEffect, useState } from "react";
import "./App.css";
import UserForm from "./components/UserForm";
import UserList from "./components/UserList";
import SkillAnalysisDashboard from "./components/SkillAnalysisDashboard";
import { getUsers } from "./services/api";

function App() {

  const [users, setUsers] = useState([]);

  const loadUsers = async () => {
    try {
      const response = await getUsers();
      setUsers(response.data || []);
    } catch (error) {
      console.error(error);
    }
  };

  useEffect(() => {
    loadUsers();
  }, []);

  return (
    <div>

      {/* ✅ ⚡ SkillOrbit Navbar */}
      <div className="navbar">
        <span className="logo">⚡ SkillOrbit</span>
        <span className="tagline">Career Intelligence Platform</span>
      </div>

      <div className="container">

        {/* ✅ User section */}
        <div className="card">
          <UserForm refreshUsers={loadUsers} />
        </div>

        <div className="card">
          <UserList users={users} refreshUsers={loadUsers} />
        </div>

        {/* ✅ Skill Analysis */}
        <div className="card">
          <SkillAnalysisDashboard />
        </div>

      </div>
    </div>
  );
}

export default App;