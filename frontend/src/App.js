import { useEffect, useState } from "react";
import "./App.css";
import UserForm from "./components/UserForm";
import UserList from "./components/UserList";
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
      <div className="navbar">
        SkillOrbit 🚀 — Your Career Growth Engine
      </div>

      <div className="container">
        <UserForm refreshUsers={loadUsers} />
        <UserList users={users} refreshUsers={loadUsers} />
      </div>
    </div>
  );
}

export default App;
