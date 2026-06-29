import React, { useState } from "react";
import "./App.css";

import AdminPanel from "./components/AdminPanel";
import SkillAnalysisDashboard from "./components/SkillAnalysisDashboard";

function App() {

  // 🔐 Auth state
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [isAdmin, setIsAdmin] = useState(false);

  // 👤 Login state
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  // 🆕 Register state
  const [registerUsername, setRegisterUsername] = useState("");
  const [registerPassword, setRegisterPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const [view, setView] = useState("login");
  const [error, setError] = useState("");

  // ✅ LOGIN
  const handleLogin = async () => {

    try {
      const res = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
      });

      const data = await res.json();

      if (data.token) {
        localStorage.setItem("token", data.token);
        localStorage.setItem("username", username);

        setIsLoggedIn(true);

        if (username === "admin") {
          setIsAdmin(true);
        }
      } else {
        setError("Invalid credentials");
      }

    } catch {
      setError("Login failed");
    }
  };

  // ✅ REGISTER
  const handleRegister = async () => {

    if (registerPassword !== confirmPassword) {
      setError("Passwords do not match");
      return;
    }

    try {
      const res = await fetch("http://localhost:8080/api/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          username: registerUsername,
          password: registerPassword
        })
      });

      const text = await res.text();

      alert(text);

      setView("login");
      setError("");

    } catch {
      setError("Registration failed");
    }
  };

  // ✅ LOGGED IN VIEWS
  if (isLoggedIn) {
    if (isAdmin) {
      return <AdminPanel />;
    }
    return <SkillAnalysisDashboard />;
  }

  // ✅ LOGIN / REGISTER UI
  return (
    <div className="login-container">

      <h2>⚡ SkillOrbit</h2>

      {view === "login" && (
        <>
          <input
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />

          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />

          <button onClick={handleLogin}>Login</button>

          <p onClick={() => setView("register")} style={{ cursor: "pointer", color: "#4da6ff" }}>
            New user? Register
          </p>
        </>
      )}

      {view === "register" && (
        <>
          <input
            placeholder="Username"
            value={registerUsername}
            onChange={(e) => setRegisterUsername(e.target.value)}
          />

          <input
            type="password"
            placeholder="Password"
            value={registerPassword}
            onChange={(e) => setRegisterPassword(e.target.value)}
          />

          <input
            type="password"
            placeholder="Confirm Password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
          />

          <button onClick={handleRegister}>Register</button>

          <p onClick={() => setView("login")} style={{ cursor: "pointer", color: "#aaa" }}>
            Back to Login
          </p>
        </>
      )}

      {error && <p style={{ color: "red" }}>{error}</p>}

    </div>
  );
}

export default App;