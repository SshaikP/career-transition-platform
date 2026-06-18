import { deleteUser } from "../services/api";

function UserList({ users, refreshUsers }) {

  const handleDelete = async (id) => {

    const confirmDelete = window.confirm("Are you sure you want to delete this user?");
    if (!confirmDelete) return;

    await deleteUser(id);
    refreshUsers();
  };

  if (!users.length) {
    return (
      <div className="card">
        <p>No users yet. Create one above 👆</p>
      </div>
    );
  }

  return (
    <div>
      <h2>Users</h2>

      {users.map((user) => (
        <div className="card" key={user.id}>
          <p><b>ID:</b> {user.userCode}</p>
          <p><b>Email:</b> {user.email}</p>

          <button className="delete" onClick={() => handleDelete(user.id)}>
            Delete
          </button>
        </div>
      ))}
    </div>
  );
}

export default UserList;