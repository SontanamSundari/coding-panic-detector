import { useEffect,useState } from "react";
import api from "../services/api";

function SubmissionPage(){
    const [sub,setsub]=useState([]);
    useEffect(()=>{
        api.get("/submissions").then((res)=>{setsub(res.data)}).catch((err)=>{console.error(err)});
    },[]);

    return(
        <div style={{ padding: "20px" }}>
            <h1>Submission History Page</h1>
            <table border="1" cellPadding="10">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Problem</th>
                        <th>Language</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {sub.map((s)=>(
                        <tr key={s.id}>
                            <td>{s.id}</td>
                            <td>{s.problem?.title}</td>
                            <td>{s.language}</td>
                            <td
                            style={{
                            color:
                            s.status==="Accepted"
                            ? "limegreen"
                            : "red"
                            }}
                            >
                            {s.status}
                            </td>
                        </tr>
                    ))}
                </tbody>

            </table>
        </div>
    );
}

export default SubmissionPage;