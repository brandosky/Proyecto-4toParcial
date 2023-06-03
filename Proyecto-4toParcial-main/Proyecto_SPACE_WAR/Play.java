import greenfoot.*; 
import greenfoot.GreenfootSound; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private Scoreboard scoreboard;
    private int score=1;
    private GreenfootSound musica;
    public Play(World level1,Scoreboard scoreboard){
        newlevel = level1;
        this.scoreboard = scoreboard;
    }

    public void act()
    {
        if (!musica.isPlaying())
        {
            musica.playLoop();
        }
        if(Greenfoot.mouseClicked(this)){
            String playerName=Greenfoot.ask("Ingresa tu nombre:");
            scoreboard.addScore(playerName,score);
            //scoreboard.saveScores();
            Greenfoot.setWorld(newlevel);
            if (musica != null && musica.isPlaying())
            {
                musica.stop();
            }
        }
    }

    public void addedToWorld(World world)
    {
        musica = new GreenfootSound("audio1.mp3");
    }

}
