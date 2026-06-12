package coding_platform.controller;

import coding_platform.model.Submission;
import coding_platform.service.PanicEventService;
import coding_platform.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    private final PanicEventService panicEventService;
    @Autowired
    private SubmissionService submissionService;

    
    @Autowired
    public SubmissionController(PanicEventService panicEventService) {
        this.panicEventService = panicEventService;
    }

    // Submit code
    @PostMapping
    public ResponseEntity<Submission> submitCode(@RequestBody Submission submission) {
        //requestbody will convert the json into submission obj
        try {
            Submission saved = submissionService.runSubmission(submission);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            // Business logic errors (e.g., Problem not found, language mismatch)
            Submission errorSubmission = new Submission();
            errorSubmission.setStatus("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorSubmission);
        } catch (Exception e) {
            // Unexpected server errors
            Submission errorSubmission = new Submission();
            errorSubmission.setStatus("Unexpected server error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorSubmission);
        }
    }

    // Get submission by ID
    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmission(@PathVariable Long id) {
        try {
            Submission submission = submissionService.getSubmissionById(id);
            return ResponseEntity.ok(submission);
        } catch (RuntimeException e) {
            Submission errorSubmission = new Submission();
            errorSubmission.setStatus("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorSubmission);
        }
    }

    // Get all submissions for a problem
    @GetMapping("/problem/{problemId}")
    public ResponseEntity<List<Submission>> getSubmissionsByProblem(@PathVariable Long problemId) {
        List<Submission> submissions = submissionService.getSubmissionsByProblem(problemId);
        return ResponseEntity.ok(submissions);
    }

    // Get all submissions
    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions() {
        return ResponseEntity.ok(submissionService.getAllSubmissions());
    }
@PostMapping("/run")
public ResponseEntity<String> runCode(@RequestBody Submission submission){
    try{
        panicEventService.saveEvent(submission.getProblem().getId(), "RUN_CLICKED", 1, "Run Button Clicked");

        String res;

        if(submission.getLanguage().equalsIgnoreCase("java")){
            res = submissionService.runCodeOnly(
                    submission.getCode(),
                    "java",
                    submission.getProblem().getId()
            );
            if(res.contains("Compilation Error")){
                panicEventService.saveEvent(
                submission.getProblem().getId(),
                "COMPILATION_ERROR",
                5,
                res
                );
            }
        }else{
            res = submissionService.runCodeOnly(
                    submission.getCode(),
                    "python",
                    submission.getProblem().getId()
            );
        }

        System.out.println("RUN RESULT = " + res);

        return ResponseEntity.ok(res);

    }catch(Exception e){
        e.printStackTrace();
        return ResponseEntity.badRequest().body("Error:"+e.getMessage());
    }

    
}
}