function UserList({ users }) {

  return (
    <div>
      <h2>Users</h2>

      {users.map((user) => (
        <div key={user.id}>
          <p><b>UserCode:</b> {user.userCode}</p>
          <p><b>Email:</b> {user.email}</p>
          <p><b>Username:</b> {user.username}</p>
          <hr/>
        </div>
      ))}
    </div>
  );
}

export default UserList;