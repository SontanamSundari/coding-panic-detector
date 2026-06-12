package coding_platform.model;

import jakarta.persistence.*;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Column(length=5000)
    private String code;

    private String language;
    @Column(length = 5000)
    private String status;

    public Submission() {}

    public Submission(Problem problem, String code, String language, String status){
        this.problem = problem;
        this.code = code;
        this.language = language;
        this.status = status;
    }

    // Getters & setters
    public Long getId() { return id; }
    public Problem getProblem() { return problem; }
    public String getCode() { return code; }
    public String getLanguage() { return language; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setProblem(Problem problem) { this.problem = problem; }
    public void setCode(String code) { this.code = code; }
    public void setLanguage(String language) { this.language = language; }
    public void setStatus(String status) { this.status = status; }
}