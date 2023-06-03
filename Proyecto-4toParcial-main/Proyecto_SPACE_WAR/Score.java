/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score  
{
    private String playerName;
    private int score;
    Ship ship;
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Score
     */
    public Score(String playerName,int score)
    {
        this.playerName=playerName;
        this.score=score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        //score=ship.checkScore(); 
        return score;
    }
}
