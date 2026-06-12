import { Link } from "react-router-dom";

function ProblemCard({problem}){
    return(
<div className="glass"
    style={{
        background: "linear-gradient(145deg,#1e293b,#0f172a)",
        padding: "20px",
        marginBottom: "15px",
        borderRadius: "10px",
        border: "1px solid #334155",
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
        transition:"0.2s",
        cursor:"pointer",
        boxShadow:"0 10px 25px rgba(0,0,0,.25)",
        transform:"translateY(-4px)"
    }}
>
    <div>
        <h3>{problem.title}</h3>

<span
style={{
    padding:"6px 12px",
    borderRadius:"20px",
    background:
        problem.difficulty === "Easy"
            ? "#166534"
            : problem.difficulty === "Medium"
            ? "#92400e"
            : problem.difficulty === "Hard"
            ? "#991b1b"
            : "#475569",
    color:"white",
    fontWeight:"bold",
    fontSize:"14px"
}}
>
    {problem.difficulty}
</span>
    </div>

    <Link to={`/problem/${problem.id}`}>
        <button
        style={{fontSize:"20px" }}
        >Solve</button>
    </Link>
</div>
    );
}

export default ProblemCard;