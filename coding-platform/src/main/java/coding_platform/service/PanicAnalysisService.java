package coding_platform.service;

import coding_platform.model.PanicEvent;
import coding_platform.repository.PanicEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PanicAnalysisService {
    @Autowired
    private PanicEventRepository repo;

    public int calculateScore(Long problemId){
        List<PanicEvent> events = repo.findByProblemId(problemId);
        int score=0;
        for(PanicEvent e:events){
            switch(e.getEventType()){
                case "COMPILATION_ERROR":
                    score+=5;
                    break;
                case "RUNTIME_ERROR":
                    score+=5;
                    break;
                case "WRONG_ANSWER":
                    score+=8;
                    break;
                case "INACTIVITY":
                    score+=10;
                    break;
                case "RAPID_DELETE":
                    score+=15;
                    break;
            }
        }
        return Math.min(score,100);
    }
    public String getlevel(int score){

        if(score <= 25)
            return "CALM";

        if(score <= 50)
            return "STRUGGLING";

        if(score <= 75)
            return "HIGH_STRESS";

        return "PANIC_DETECTED";
    }
    
public String getRecovery(Long problemId){

    List<PanicEvent> events =
            repo.findByProblemId(problemId);

    int compilation = 0;
    int runtime = 0;
    int inactivity = 0;
    int wronganswers = 0;
    int rapiddelete = 0;

    for(PanicEvent e : events){

        switch(e.getEventType()){

            case "COMPILATION_ERROR":
                compilation++;
                break;

            case "RUNTIME_ERROR":
                runtime++;
                break;

            case "WRONG_ANSWER":
                wronganswers++;
                break;

            case "INACTIVITY":
                inactivity++;
                break;

            case "RAPID_DELETE":
                rapiddelete++;
                break;
        }
    }

    // COMBINED BEHAVIOR PATTERNS

    if(wronganswers >= 3 && rapiddelete >= 2){
        return "You appear to be changing solution strategies frequently after repeated failures. Revisit the problem requirements and commit to one approach before coding.";
    }

    if(compilation >= 4){
        return "Multiple compilation failures detected. Make smaller code changes and compile after each change instead of writing large blocks at once.";
    }

    if(runtime >= 3){
        return "Repeated runtime errors detected. Focus on edge cases such as null values, invalid inputs and array bounds.";
    }

    if(wronganswers >= 3){
        return "Several wrong answers detected. Manually dry-run the sample input and compare every step with your program output.";
    }

    if(rapiddelete >= 2){
        return "Frequent code rewrites detected. Write pseudocode or algorithm steps before modifying the implementation.";
    }

    if(inactivity >= 1){
        return "Long inactivity detected. Break the problem into input handling, processing and output generation.";
    }

    return "Progress looks stable. Continue building and testing incrementally.";
}

public String getPattern(Long problemId){

    List<PanicEvent> events =
            repo.findByProblemId(problemId);

    int compilation = 0;
    int runtime = 0;
    int inactivity = 0;
    int wronganswers = 0;
    int rapiddelete = 0;

    for(PanicEvent e : events){

        switch(e.getEventType()){

            case "COMPILATION_ERROR":
                compilation++;
                break;

            case "RUNTIME_ERROR":
                runtime++;
                break;

            case "WRONG_ANSWER":
                wronganswers++;
                break;

            case "INACTIVITY":
                inactivity++;
                break;

            case "RAPID_DELETE":
                rapiddelete++;
                break;
        }
    }

    if(wronganswers >= 3 && rapiddelete >= 2)
        return "Frequent Strategy Switching";

    if(compilation >= 4)
        return "Repeated Compilation Failures";

    if(runtime >= 3)
        return "Repeated Runtime Errors";

    if(wronganswers >= 3)
        return "Repeated Wrong Answers";

    if(rapiddelete >= 2)
        return "Frequent Code Rewrites";

    if(inactivity >= 1)
        return "Extended Inactivity";

    return "Stable Progress";
}
}
