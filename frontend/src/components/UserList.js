import { deleteUser } from "../services/api";

function UserList({ users, refreshUsers }) {

  const handleDelete = async (id) => {
    await deleteUser(id);
    refreshUsers();
  };

  return (
    <div>
      <h2>Users</h2>

      {users.map((user) => (
        <div key={user.id} style={{ border: "1px solid #ccc", margin: "10px", padding: "10px" }}>
          <p><b>UserCode:</b> {user.userCode}</p>
          <p><b>Email:</b> {user.email}</p>
          <p><b>Username:</b> {user.username}</p>

          <button onClick={() => handleDelete(user.id)}>
            Delete
          </button>

          <hr/>
        </div>
      ))}
    </div>
  );
}

export default UserList;
