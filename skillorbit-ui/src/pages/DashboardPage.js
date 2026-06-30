import React from "react";
import SkillAnalysisDashboard from "../components/SkillAnalysisDashboard";
import AdminPanel from "../components/AdminPanel";

function DashboardPage() {

  const role = localStorage.getItem("role");

  console.log("ROLE FROM STORAGE:", role);

  const handleLogout = () => {
    localStorage.clear();
    window.location.href = "/login";
  };

  return (
    <div className="app-container">

      {/* NAVBAR */}
      <div className="navbar">

        <div className="nav-left">
          ⚡ SkillOrbit
        </div>

        <div className="nav-right">
          <button className="logout-btn" onClick={handleLogout}>
            Logout
          </button>
        </div>

      </div>

      {/* CONTENT */}
      <div className="content">

        {role?.toUpperCase() === "ADMIN" ? (
          <AdminPanel />
        ) : (
          <SkillAnalysisDashboard />
        )}

      </div>

    </div>
  );
}

export default DashboardPage;