import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Ship ship;
    private Scoreboard scoreboard;

    private String PointsName="puntuacion.txt";
    private int EnemySpeed = 1;

    public MyWorld(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,600,1);
        scoreboard=new Scoreboard(PointsName);
        prepare();
    }

    public void act(){
    }

    private void prepare()
    {

        Learn learn = new Learn();
        addObject( learn,109,523);
        Play play = new Play( new Level1(),scoreboard);
        addObject(play,100,408);
        Records records = new Records();
        addObject(records,105,278);
        addObject(scoreboard,100,50);
        Home home = new Home();
        addObject(home,10,600);
    }

}
