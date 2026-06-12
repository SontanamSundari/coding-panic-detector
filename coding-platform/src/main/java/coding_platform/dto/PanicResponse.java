package coding_platform.dto;

public class PanicResponse {
    private int score;
    private String level;
    private String suggestion;
    public PanicResponse(int score,String level,String suggestion){
        this.score=score;
        this.level=level;
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
}
