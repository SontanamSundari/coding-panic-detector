package coding_platform.controller;

import coding_platform.dto.PanicResponse;
import coding_platform.service.PanicAnalysisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/panic")
public class PanicAnalysisController {
    @Autowired
    private PanicAnalysisService service;

    @GetMapping("/{problemId}")
    public PanicResponse getPanic(@PathVariable Long problemId){
        int score = service.calculateScore(problemId);
        String level = service.getlevel(score);
        String pattern = service.getPattern(problemId);
        String suggestion =service.getRecovery(problemId);
        return new PanicResponse(
                score,
                level,
                pattern,
                suggestion
        );
    }
    
}
