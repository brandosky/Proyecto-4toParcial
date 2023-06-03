import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;
/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends Botones
{
    private int score=5;
    private GreenfootSound musica;
    private Scoreboard scoreboard;
    private Ship ship;
    /**
     * Act - do whatever the Home wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //score=ship.getScore();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MyWorld());
        }
    }

    public void addedToWorld(World world)
    {
        musica = new GreenfootSound("audiofin.mp3");
    }
}
