import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private Scoreboard scoreboard;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1);
        prepare();
        //stopped();
    }

    public void prepare()
    {
        Home home = new Home();
        addObject(home,52,548);
    }

    public void stopped(){
        scoreboard.saveScores();
    }
}
