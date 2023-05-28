import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Learn_now here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Learn_now extends World
{

    /**
     * Constructor for objects of class Learn_now.
     * 
     */
    public Learn_now()
    {  super(1000, 600, 1); 
        prepare();   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
    }
    private void prepare()
    {
        Home home = new Home();
        addObject(home,52,548);
        
        
    }
}
