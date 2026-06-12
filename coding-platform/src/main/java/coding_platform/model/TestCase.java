package coding_platform.model;

import jakarta.persistence.*;

@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Proper Many-to-One relation with Problem
    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Column(length = 1000)
    private String input;

    @Column(length = 1000)
    private String expectedOutput;
    public TestCase() {}

    public Long getId() {
        return id;
    }
    public Problem getProblem() {
        return problem;
    }
    public String getInput() {
        return input;
    }
    public String getExpectedOutput() {
        return expectedOutput;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setProblem(Problem problem) {
        this.problem = problem;
    }
    public void setInput(String input) {
        this.input = input;
    }
    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }
}