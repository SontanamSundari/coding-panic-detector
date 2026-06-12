package coding_platform.model;

import jakarta.persistence.*;

@Entity
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String difficulty;

    // Example shown to users (NOT used for judging)
    private String inputExample;
    private String outputExample;

    public Problem() {}

    public Problem(String title, String description, String difficulty,
                   String inputExample, String outputExample) {
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.inputExample = inputExample;
        this.outputExample = outputExample;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDifficulty() { return difficulty; }
    public String getInputExample() { return inputExample; }
    public String getOutputExample() { return outputExample; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public void setInputExample(String inputExample) { this.inputExample = inputExample; }
    public void setOutputExample(String outputExample) { this.outputExample = outputExample; }
}