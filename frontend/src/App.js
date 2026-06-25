import { useState } from "react";
import Login from "./components/Login";
import SkillAnalysisDashboard from "./components/SkillAnalysisDashboard";
import AdminPanel from "./components/AdminPanel";

function App() {
  const [loggedIn, setLoggedIn] = useState(
    !!localStorage.getItem("token")
  );

  const isAdmin = localStorage.getItem("username") === "admin";
  const handleLogin = () => {
    setLoggedIn(true);
  };

  return (
    <div>
      {!loggedIn ? (
        <Login onLogin={handleLogin} />
      ) : isAdmin ? (
        <AdminPanel />
      ) : (
        <SkillAnalysisDashboard />
      )}
    </div>
  );
}

export default App;