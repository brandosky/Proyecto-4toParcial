import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Botones
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public final World newlevel;
    public Play(World nivel_1){
         newlevel = nivel_1;
    }
    public void act()
    {
        // Add your action code here.
    if(Greenfoot.mouseClicked(this)){
        Greenfoot.setWorld(newlevel);
     }
    }
}
