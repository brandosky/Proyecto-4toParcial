import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Winner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Winner extends World
{
     private GreenfootSound musica;
     private Scoreboard scoreboard;
    /**
     * Constructor for objects of class Winner.
     * 
     */
    public Winner()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        act();
        //stopped();
    }
   

    public void act(){
        prepare();/*
            if (!musica.isPlaying()){
                musica.play();
            }*/
    }

    public void prepare()
    {
        Home home = new Home();
        addObject(home,52,548);
    }
    public void addedToWorld(World world)
    {
        musica = new GreenfootSound("audiofin.mp3");
    }
}
