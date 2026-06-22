import { useState } from "react";
import SkillChart from "./SkillChart";

function SkillAnalysisDashboard() {

  const [currentSkills, setCurrentSkills] = useState("");
  const [targetRole, setTargetRole] = useState("");
  const [result, setResult] = useState(null);
  const [error, setError] = useState("");

  // ✅ Dynamic Base URL (works for all environments)
  const BASE_URL = process.env.REACT_APP_API_URL || "";

  const handleAnalyze = async () => {
    try {
      setError("");

      const url = `${BASE_URL}/api/analysis/personalized?userId=1&currentSkills=${encodeURIComponent(currentSkills)}&targetRole=${encodeURIComponent(targetRole)}`;

      const response = await fetch(url, {
        method: "POST",
      });

      if (!response.ok) {
        const text = await response.text();
        throw new Error(`API Error: ${response.status} - ${text}`);
      }

      const data = await response.json();
      setResult(data);

    } catch (err) {
      console.error("Analysis Error:", err);
      setError("❌ Failed to analyze skills. Please check backend.");
    }
  };

  return (
    <div className="analysis-section">

      <h2>📊 Career Analysis</h2>

      {/* ✅ Input Section */}
      <div>
        <input
          placeholder="Current Skills"
          value={currentSkills}
          onChange={(e) => setCurrentSkills(e.target.value)}
        />

        <input
          placeholder="Target Role"
          value={targetRole}
          onChange={(e) => setTargetRole(e.target.value)}
        />

        <button onClick={handleAnalyze}>Analyze</button>
      </div>

      {/* ✅ Error Message */}
      {error && <p style={{ color: "red" }}>{error}</p>}

      {/* ✅ Results */}
      {result && (
        <div className="dashboard">

          {/* ✅ Skill Gaps */}
          <div className="card">
            <h3>🎯 Skill Gaps</h3>

            {result.scoredGaps?.map((item, i) => (
              <div className="skill-card" key={i}>
                <b>{item.skill}</b>
                <span>Score: {item.score}</span>
                <span className={item.priority.toLowerCase()}>
                  {item.priority}
                </span>
              </div>
            ))}
          </div>

          {/* ✅ Chart */}
          <div className="card">
            <h3>📊 Skill Chart</h3>
            <SkillChart data={result.scoredGaps} />
          </div>

          {/* ✅ Learning Plan */}
          <div className="card">
            <h3>📚 Learning Plan</h3>
            <ul>
              {result.learningPlan?.map((p, i) => (
                <li key={i}>{p}</li>
              ))}
            </ul>
          </div>

          {/* ✅ Roadmap */}
          <div className="card">
            <h3>🛣️ Roadmap</h3>
            <ul>
              {result.roadmap?.map((p, i) => (
                <li key={i}>{p}</li>
              ))}
            </ul>
          </div>

        </div>
      )}

    </div>
  );
}

export default SkillAnalysisDashboard;