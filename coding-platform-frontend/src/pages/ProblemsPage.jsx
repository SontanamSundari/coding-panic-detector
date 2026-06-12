import { useEffect, useState } from "react";
import ProblemCard from "../components/ProblemCard";
import api from "../services/api";
import { FaBook } from "react-icons/fa";

function ProblemsPage(){
    const[problems,setproblems]=useState([]);
    const [search,setsearch]=useState("");
    const [diff,setdiff]=useState("All");
    const[stats,setstats]=useState({
        problems:0,
        submissions:0,
        accepted:0
    });

    useEffect(()=>{
        api.get("/problems").then((response)=>{
            setproblems(response.data);
            setstats(prev => ({
            ...prev,
            problems: response.data.length
        }));
        }).catch((error)=>{
            console.error("Error fetchinng Problem:",error);
        });

    api.get("/submissions")
    .then((res)=>{

        const totalSub = res.data.length;

        {/*const accepted =
            res.data.filter(
                s => s.status === "Accepted"
            ).length;

        setstats(prev => ({
            ...prev,
            submissions: totalSub,
            accepted: accepted
        }));*/}

    });

    },[]);
    const filterprob = problems.filter((p)=>{
        const match=p.title.toLowerCase().includes(search.toLowerCase());
        const matchdiff = diff === "All" || p.difficulty === diff;
        return match && matchdiff;
    });

    return(
        <>
        <div style={{ padding: "20px" ,marginBottom: "20px", fontSize:"20px"}}>
            <div
            style={{
                display:"flex",
                gap:"30px",
                marginBottom:"20px"
            }}
            >

            <div>
                <h3>Total Problems</h3>
                <p>{stats.problems}</p>
            </div>

            {/*<div>
                <h3>Total Submissions</h3>
                <p>{stats.submissions}</p>
            </div>

            <div>
                <h3>Accepted</h3>
                <p>{stats.accepted}</p>
            </div>*/}

            </div>
            <h1>Problems</h1>
            <input
                style={{fontSize:"20px",marginBottom:"20px" , marginRight:"20px"}}
                type="text"
                placeholder="Search Problems"
                value={search}
                onChange={(e)=>setsearch(e.target.value)}
                
            />
            <select value={diff}
                    onChange={(e)=>setdiff(e.target.value)}
                    style={{fontSize:"20px",marginBottom:"20px" , marginRight:"20px"}}
            >
                <option value="All">All</option>
                <option value="Easy">Easy</option>
                <option value="Medium">Medium</option>
                <option value="Hard">Hard</option>

            </select>
            
            {filterprob.map((problem)=>(
                <ProblemCard key={problem.id} problem={problem} />
            ))}
        </div>
        </>

    );
}
export default ProblemsPage;