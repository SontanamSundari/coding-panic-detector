import Editor from "@monaco-editor/react";

function CodeEditor({code,setcode}){
    return(
        <Editor
        height="500px"
        defaultLanguage="java"
        value={code}
        onChange={(value)=>setcode(value)}
        />
    );
}

export default CodeEditor;