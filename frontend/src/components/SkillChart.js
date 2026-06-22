import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
} from "chart.js";

import { Bar } from "react-chartjs-2";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

function SkillChart({ data }) {

  if (!data || data.length === 0) return null;

  const chartData = {
    labels: data.map(item => item.skill),
    datasets: [
      {
        label: "Skill Score",
        data: data.map(item => item.score),
        backgroundColor: "rgba(54, 162, 235, 0.6)"
      }
    ]
  };

  return (
    <div style={{ marginTop: "20px" }}>
      <Bar data={chartData} />
    </div>
  );
}

export default SkillChart;