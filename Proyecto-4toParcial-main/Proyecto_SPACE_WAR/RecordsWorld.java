import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RecordsWorld1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecordsWorld extends World
{
    private  Scoreboard scoreboard;
     private String PointsName="puntuacion.txt";
    /**
     * Constructor for objects of class RecordsWorld1.
     * 
     */
     public RecordsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        scoreboard = new Scoreboard(PointsName);
        prepare();
    }
    private void prepare()
    {
        Home home = new Home();
        addObject(home,52,548);
        addObject(scoreboard, 500, 300);
        scoreboard.loadScores();
        scoreboard.showScores();
    }
}
