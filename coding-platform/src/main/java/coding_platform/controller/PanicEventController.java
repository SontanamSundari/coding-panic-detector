package coding_platform.controller;
import coding_platform.model.PanicEvent;
import coding_platform.repository.PanicEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins="http://localhost:5173" )
@RestController
@RequestMapping("/panic-events")
public class PanicEventController {
    @Autowired 
    private PanicEventRepository repo;

    @GetMapping("/{problemId}")
    public List<PanicEvent> getEvents(@PathVariable Long problemId){
        return repo.findByProblemId(problemId);

    }
    @DeleteMapping("/{problemId}")
public void resetEvents(
        @PathVariable Long problemId
){
    repo.deleteByProblemId(problemId);
}
}
