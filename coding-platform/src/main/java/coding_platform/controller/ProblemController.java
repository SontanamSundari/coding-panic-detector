package coding_platform.controller;

import coding_platform.model.Problem;
import coding_platform.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController  //This class will handle HTTP requests and return JSON.
@RequestMapping("/problems")
public class ProblemController {
    @Autowired  //Spring automatically provides an instance of ProblemRepository
    private ProblemRepository probrepo;
    @PostMapping
    public Problem addProblem(@RequestBody Problem problem){
        return probrepo.save(problem);
    }

    @GetMapping
    public List<Problem> getProblems(){
        return probrepo.findAll();
    }

    @GetMapping("/{id}")
    public Problem getProblembyId(@PathVariable Long id){
        return probrepo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProblem(@PathVariable Long id){
        probrepo.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Problem updateProblem(@PathVariable Long id , @RequestBody Problem updatedProblem){
        Problem problem = probrepo.findById(id).orElse(null);
        if(problem !=null){
            problem.setTitle(updatedProblem.getTitle());
            problem.setDescription(updatedProblem.getDescription());
            problem.setDifficulty(updatedProblem.getDifficulty());
            return probrepo.save(problem);

        }
        return null;
    }
}
