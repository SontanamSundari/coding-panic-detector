package coding_platform.controller;

import coding_platform.model.TestCase;
import coding_platform.model.Problem;
import coding_platform.repository.TestCaseRepository;
import coding_platform.repository.ProblemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Autowired
    private ProblemRepository problemRepository;

    // Add a test case for a problem
    @PostMapping("/problems/{problemId}")
    public TestCase addTestCase(@PathVariable Long problemId, @RequestBody TestCase testCase) {
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() -> new RuntimeException("Problem not found"));

        testCase.setProblem(problem); // associate test case with the problem
        return testCaseRepository.save(testCase);
    }

    // Get all test cases for a problem
    @GetMapping("/problems/{problemId}")
    public List<TestCase> getTestCases(@PathVariable Long problemId) {
        Problem problem = problemRepository.findById(problemId)
                .orElseThrow(() -> new RuntimeException("Problem not found"));

        return testCaseRepository.findByProblemId(problem.getId());
    }
}