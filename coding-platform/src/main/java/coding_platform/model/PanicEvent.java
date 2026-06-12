package coding_platform.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class PanicEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventType;
    private Long problemId;
    private int severity;
    private String details;
    private LocalDateTime timestamp;

    public PanicEvent(){
        this.timestamp=LocalDateTime.now();
    }
    public Long getId(){
        return id;
    }
    public Long getProblemId(){
        return problemId;
    }
    public String getEventType(){
        return eventType;
    }
    public String getDetails(){
        return details;
    }
    public int getSeverity(){
        return severity;
    }


    public void setId(Long id){
        this.id=id;
    }
    public void setProblemId(Long problemId){
        this.problemId=problemId;
    }
    public void setEventType(String eventType){
        this.eventType=eventType;
    }
    public void setDetails(String details){
        this.details=details;
    }
    public void setSeverity(int severity){
        this.severity=severity;
    }
    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp=timestamp;
    }
    
}
