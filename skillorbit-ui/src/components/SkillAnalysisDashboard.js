import React, { useState } from "react";

function SkillAnalysisDashboard() {

  const [currentRole, setCurrentRole] = useState("");
  const [targetRole, setTargetRole] = useState("");

  const [skillList, setSkillList] = useState([]);
  const [skills, setSkills] = useState({});
  const [results, setResults] = useState([]);

  const loadSkills = async () => {
    const res = await fetch(`http://localhost:8080/api/roleskills/${targetRole}`);
    const data = await res.json();

    const skillObj = {};
    data.forEach(s => skillObj[s.skill] = 0);

    setSkillList(data);
    setSkills(skillObj);
    setResults([]);
  };

    const handleAnalyze = async () => {

      console.log("CLICKED ANALYZE ✅");
      

      const response = await fetch("http://localhost:8080/api/analysis", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          role: targetRole,      // ✅ CRITICAL FIX
          skills: skills
        })
        
      });

      console.log("Skills before sending:", skills);            
      
      const handleChange = (skill, value) => {
        console.log("CHANGE:", skill, value);

        setSkills(prev => ({
          ...prev,
          [skill]: Number(value) || 0
        }));
      };

      const data = await response.json();

      console.log("RESPONSE RECEIVED ✅", data);

      setResults(data);

    };


  return (
    <div>

      <h2>⚡ SkillOrbit</h2>

      <input
        placeholder="Current Role"
        value={currentRole}
        onChange={e => setCurrentRole(e.target.value)}
      />

      <input
        placeholder="Target Role"
        value={targetRole}
        onChange={e => setTargetRole(e.target.value)}
      />

      <button onClick={loadSkills}>Load Skills</button>


{skillList.length > 0 && (
  <div>
    <h4>Enter Skill Levels</h4>

    {skillList.map((s, i) => (
      <div key={i} style={{ marginBottom: "10px" }}>
        <label>{s.skill}</label>

        <input
          type="number"
          min="0"
          max="10"
          value={skills[s.skill] ?? ""}   // ✅ ✅ ✅ THIS LINE IS CRITICAL
          onChange={(e) => handleChange(s.skill, e.target.value)}
        />
      </div>
    ))}
  </div>
)}

      <button onClick={handleAnalyze}>Analyze</button>

        {results.map((r, i) => (
          <div key={i} style={{ border: "1px solid gray", padding: "10px", margin: "10px" }}>

            <h3>{r.skill}</h3>

            <p>🔥 Priority: {r.priority}</p>
            <p>📉 Gap: {r.gap}</p>

            <h4>✅ FREE PATH</h4>
            <ul>
              {r.freePath.map((s, idx) => <li key={idx}>{s}</li>)}
            </ul>

            <h4>💰 PREMIUM PATH</h4>
            <ul>
              {r.premiumPath.map((s, idx) => <li key={idx}>{s}</li>)}
            </ul>

          </div>
        ))}
      </div>
  );
}
export default SkillAnalysisDashboard;