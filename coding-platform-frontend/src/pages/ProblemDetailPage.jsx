import { useEffect,useState } from "react";
import { useParams } from "react-router-dom";
import CodeEditor from "../components/CodeEditor";

import api from "../services/api";

function ProblemDetailPage(){
    const {id} = useParams();
    const [problem,setproblem]=useState(null);
    const[lang,setlang]=useState("java");
    const[code,setcode]=useState("");
    const[res,setres]=useState("");
    const[run,setrun]=useState("");
    const [panic,setpanic]=useState(null);

    const fetchPanicData=()=>{
        api.get(`/panic/${problem.id}`).then((res)=>{setpanic(res.data)}).catch((err)=>{console.error(err)});
    }

    const resetPanic = () => {

    api.delete(`/panic-events/${problem.id}`)
    .then(()=>{

        setpanic({
            score:0,
            level:"CALM"
        });

    })
    .catch((err)=>{
        console.error(err);
    });
};

    
const loadPanicData = () => {

    if(!problem) return;

    api.get(`/panic/${problem.id}`)
        .then((res)=>{
            setpanic(res.data);
        })
        .catch((err)=>{
            console.error(err);
        });
}
    
    useEffect(()=>{
        api.get(`/problems/${id}`)
        .then((response)=>{
            setproblem(response.data);

            api.get(`/panic/${id}`).then((res)=>{setpanic(res.data)});
        }) 
        .catch((error)=>{
            console.error("Error Fetching due to:",error);
        });
    },[id]);
    if(!problem){
        return <h2 style={{ padding: "20px" }}> Loading...</h2>
    }

    const handleRun=()=>{
        const submission={
            problem:{
                id:problem.id
            },
            language:lang,
            code:code
        };
        api.post("/submissions/run", submission)
.then((response) => {
    console.log("RUN RESPONSE =", response.data);
    setrun(String(response.data));
    loadPanicData();
    fetchPanicData();
})
.catch((err) => {
    console.error(err);
    setrun("Run Failed");
});
    }


    const handleSubmit=()=>{
        const submission={
            problem:{
                id:problem.id
            },
            language:lang,
            code:code
        };
        console.log(submission);
        api.post("/submissions",submission).then((res)=>{setres(res.data.status); loadPanicData();}).catch((err)=>{console.error(err);setres("Submission Failed")});
    };




    return (
        <>
        <div style={{
        padding: "20px",
        display: "flex",
        gap: "30px"
        }}>

       { /* left side*/}
        
        <div style={{ flex: 1 , fontSize:"20px",lineHeight:"1.8"}}>
            <h1>{problem.title}</h1>
            <p><strong>Difficulty: </strong>{problem.difficulty}</p>
            <h3>Description: </h3>
            <p
            style={{
                fontSize:"25px",
                lineHeight:"1.8",
                color:"#e2e8f0",
                marginBottom:"25px"
            }}
            >
                {problem.description}
            </p>
            <h3>Sample Input:</h3>
            <pre>{problem.inputExample}</pre>
            <h3>Sample Output:</h3>
            <pre>{problem.outputExample}</pre>
        </div>

        {/*rigth side */}

        <div  style={{
        flex: 1,
        border: "1px solid #ccc",
        padding: "20px",
        borderRadius: "10px"
      }}>
        <>
            <h3>Select Language</h3>
        <select value={lang}
                onChange={(e)=>setlang(e.target.value)}
        >
            <option value="java">Java</option>
            <option value="python">Python</option>
        </select>
        <br/> <br/>
        <CodeEditor
            code={code}
            setcode={setcode}
        />
        <br/> <br/>
        <button onClick={handleRun}>
            RunCode
        </button>
        <button onClick={handleSubmit} style={{marginLeft:"10px"}}>
            Submit
        </button>
        </>
        <h3>Run Output</h3>
        <div
        style={{
            background:"#1e1e1e",
            padding:"15px",
            borderRadius:"10px",
            minHeight:"80px",
            marginBottom:"15px"
        }}
        >
            {run}
        </div>

        <h3>{res}</h3>
        {panic && (

<div
style={{
    marginTop:"20px",
    background:"#1e1e1e",
    padding:"15px",
    borderRadius:"10px",
    border:"1px solid #444"
}}
>

<h2>Panic Detector</h2>

<h3>

{panic.level === "CALM" && "🟢 CALM"}

{panic.level === "STRUGGLING" && "🟡 STRUGGLING"}

{panic.level === "HIGH_STRESS" && "🟠 HIGH STRESS"}

{panic.level === "PANIC_DETECTED" && "🔴 PANIC DETECTED"}

</h3>

<p>

Score:
<strong> {panic.score}/100 </strong>

</p>


<div
style={{
width:"100%",
height:"12px",
background:"#334155",
borderRadius:"10px",
overflow:"hidden"
}}
>
<div
style={{
width:`${panic.score}%`,
height:"100%",
background:
panic.score < 25
? "#22c55e"
: panic.score < 50
? "#eab308"
: panic.score < 75
? "#f97316"
: "#ef4444"
}}
/>
</div>

    {/* <p>
        <strong>Level:</strong> {panic.level}
    </p> */}
 <p>
        <strong>Recovery Suggestion:</strong>
        <br/>
        {panic.suggestion}
    </p>










<button
    onClick={resetPanic}
    style={{
        marginTop:"10px"
    }}
>
    Reset Session
</button>

</div>

)}

        </div>

      </div>
        </>


    );
}

export default ProblemDetailPage;