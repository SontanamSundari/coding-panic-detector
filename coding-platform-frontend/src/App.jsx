import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import ProblemsPage from "./pages/ProblemsPage";
import ProblemDetailPage from "./pages/ProblemDetailPage";
import SubmissionPage from "./pages/SubmissionPage";

function App() {
  return (
    <BrowserRouter>
    
      <Navbar />

      <Routes>
        <Route path="/" element={<ProblemsPage />} />
        <Route path="/problem/:id" element={<ProblemDetailPage />} />
        <Route path="/submissions" element={<SubmissionPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;