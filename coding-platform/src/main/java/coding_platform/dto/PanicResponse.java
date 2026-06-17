package coding_platform.dto;

public class PanicResponse {
    private int score;
    private String level;
    private String pattern;
    private String suggestion;
    public PanicResponse(int score,String level,String pattern,String suggestion){
        this.score=score;
        this.level=level;
        this.pattern = pattern;
        this.suggestion=suggestion;
    }
    public int getScore(){
        return score;
    }
    public String getLevel(){
        return level;
    }
    public String getSuggestion(){
        return suggestion;
    }
    public String getPattern(){
    return pattern;
}

}
