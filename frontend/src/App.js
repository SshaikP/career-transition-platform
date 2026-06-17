import { useEffect, useState } from "react";
import UserForm from "./components/UserForm";
import UserList from "./components/UserList";
import { getUsers } from "./services/api";

function App() {

  const [users, setUsers] = useState([]);

  const loadUsers = async () => {
    const response = await getUsers();
    setUsers(response.data); // IMPORTANT
  };

  useEffect(() => {
    loadUsers();
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>Career Transition Platform</h1>

      <UserForm refreshUsers={loadUsers} />

      <UserList users={users} />
    </div>
  );
}

export default App;