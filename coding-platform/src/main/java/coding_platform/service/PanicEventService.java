package coding_platform.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coding_platform.model.*;
import coding_platform.repository.*;

@Service
public class PanicEventService {
    @Autowired
    private PanicEventRepository repo;    

    public void saveEvent(Long problemId,String eventType,int severity,String details){
        PanicEvent event = new PanicEvent();
        event.setProblemId(problemId);
        event.setEventType(eventType);
        event.setSeverity(severity);
        event.setDetails(details);
        repo.save(event);
    }
}
