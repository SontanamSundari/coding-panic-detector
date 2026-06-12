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
        List<PanicEvent> events=repo.findByProblemId(problemId);
        int compilation=0;
        int runtime=0;
        int inactivity=0;
        int wronganswers=0;
        int rapiddelete=0;

        for(PanicEvent e:events){
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

            case "RAPID_DELETE":
                rapiddelete++;
                break;
        }
        }
            if(compilation >= 3){
        return "Too many compilation errors. Check syntax, braces and variable names carefully.";
    }

    if(runtime>= 3){
        return "Runtime errors detected repeatedly. Check array bounds and null values.";
    }

    if(wronganswers >= 3){
        return "Multiple wrong answers. Try tracing the program manually using sample inputs.";
    }

    if(rapiddelete >= 2){
        return "Frequent code rewrites detected. Slow down and create a plan before coding.";
    }

    return "Keep going. Progress looks stable.";
    }
}
