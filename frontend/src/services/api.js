// ✅ Dynamic Base URL (works for Local + Docker + Cloud)
const BASE_URL = process.env.REACT_APP_API_URL 
  ? `${process.env.REACT_APP_API_URL}/api/users` 
  : "/api/users";

// ✅ Create User
export const createUser = async (user) => {
  const response = await fetch(BASE_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(user)
  });

  return handleResponse(response);
};

// ✅ Get Users
export const getUsers = async () => {
  const response = await fetch(BASE_URL);
  return handleResponse(response);
};

// ✅ Delete User
export const deleteUser = async (id) => {
  const response = await fetch(`${BASE_URL}/${id}`, {
    method: "DELETE"
  });

  return handleResponse(response);
};

// ✅ Common Response Handler (VERY IMPORTANT)
const handleResponse = async (response) => {
  if (!response.ok) {
    const text = await response.text();
    throw new Error(`API Error: ${response.status} - ${text}`);
  }
  return response.json();
};