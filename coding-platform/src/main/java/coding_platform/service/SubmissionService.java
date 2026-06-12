package coding_platform.service;

import coding_platform.model.Submission;
import coding_platform.model.Problem;
import coding_platform.repository.SubmissionRepository;
import coding_platform.repository.ProblemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private CodeExecutionService codeExecutionService;

    @Autowired
    private PanicEventService panicEventService;

    // Run a submission against test cases
    public Submission runSubmission(Submission submission) {

        // 1️⃣ Check if problem ID exists
        if (submission.getProblem() == null || submission.getProblem().getId() == null) {
            submission.setStatus("Error: Problem ID missing");
            return submissionRepository.save(submission);
        }

        Long problemId = submission.getProblem().getId();

        panicEventService.saveEvent(problemId, "SUBMIT_CLICKED", 1, "User submitted solution");

        // 2️⃣ Fetch problem from DB
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() -> new RuntimeException("Problem not found"));
        System.out.println("RUN INPUT:");
        System.out.println(problem.getInputExample());

        submission.setProblem(problem);

        try {

            // 3️⃣ Execute code using CodeExecutionService
            String result = codeExecutionService.runSubmission(submission);

            submission.setStatus(result);

            if(result.contains("Compilation Error")){
                panicEventService.saveEvent(problemId, "COMPILATION_ERROR", 5, result);

            }else if(result.contains("Runtime Error")){
                panicEventService.saveEvent(problemId, "RUNTIME_ERROR", 5, result);
            }else if(result.contains("Wrong Answer")){
                panicEventService.saveEvent(problemId, "WRONG_ANSWER", 4, result);
            }else if(result.equals("Accepted")){
                panicEventService.saveEvent(problemId, "Accepted", 0, "Accepted");
            }

        } catch (Exception e) {

            submission.setStatus("Execution Error: " + e.getMessage());

        }

        // 4️⃣ Save submission result
        return submissionRepository.save(submission);
    }


    // Get submission by ID
    public Submission getSubmissionById(Long submissionId) {
        return submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
    }


    // Get submissions by problem
    public List<Submission> getSubmissionsByProblem(Long problemId) {
        return submissionRepository.findAll().stream()
                .filter(s -> s.getProblem().getId().equals(problemId))
                .toList();
    }


    // Get all submissions
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }
    public String runCodeOnly(String code,String lang,Long problemId){
        Problem problem=problemRepository.findById(problemId).orElseThrow(()->new RuntimeException("Problem Not found"));
        Submission tempsub=new Submission();
        tempsub.setCode(code);
        tempsub.setLanguage(lang);

        Problem tempprob=new Problem();
        tempprob.setId(problemId);
        tempsub.setProblem(tempprob);

        return codeExecutionService.runCodeWithInput(code, lang, problem.getInputExample());

    }


}