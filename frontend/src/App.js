import { useEffect, useState } from "react";
import UserForm from "./components/UserForm";
import UserList from "./components/UserList";
import { getUsers } from "./services/api";

function App() {

  const [users, setUsers] = useState([]);

  const loadUsers = async () => {
    const response = await getUsers();
    setUsers(response.data);
  };

  useEffect(() => {
    loadUsers();
  }, []);

  return (
    <div
      style={{
        padding: "20px",
        fontFamily: "Arial",
        maxWidth: "600px",
        margin: "auto"
      }}
    >
      <h1>Career Transition Platform</h1>

      <UserForm refreshUsers={loadUsers} />

      <UserList users={users} refreshUsers={loadUsers} />
    </div>
  );
}

export default App;