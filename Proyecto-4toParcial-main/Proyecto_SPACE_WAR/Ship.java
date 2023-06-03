import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;
/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    private final World newLevel;
    private final World gameOver;
    private int speed=6;
    private int health=3;
    private int score=1;
    private int cooldown=0;
    private Scoreboard scoreboard;
    private GreenfootSound music;
    /**
     * Act - do whatever the ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ship(World level2,World level4){
        newLevel=level2;
        gameOver=level4;
    }

    public void act()
    {
        move();
        checkCollision();
        checkKeyPress();
        checkFireCooldown(); 
        update();
        checkScore();
        if (getWorld()!=null){
            if (!music.isPlaying()){
                music.play();
            }
        }else{
            if (music != null && music.isPlaying())
            {
                music.stop();
            }
        }
    }

    private void move(){
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + speed, getY());
        }
    }

    private void checkFireCooldown() {
        if (cooldown > 0) {
            cooldown--;
        }
        else if (Greenfoot.isKeyDown("space")) {
            shootLaser();
            cooldown = 5; // Cooldown de disparo
        }
    }

    private void checkCollision(){
        //Actor laser=getOneIntersectingObject(Laser.class);
        Actor enemy=getOneIntersectingObject(Enemy.class);
        Actor powerUpPointsPlus=getOneIntersectingObject(PowerUpPointsPlus.class);

        /*if(laser !=null){
        getWorld().removeObject(laser);
        score+=10;
        }*/
        if(enemy!=null){
            getWorld().removeObject(enemy);
            shipdecreaseHealth();
        }
        if(powerUpPointsPlus!=null){
            getWorld().removeObject(powerUpPointsPlus);
            score+=3;
        }
    } 

    private void update(){
        World world=getWorld();
        world.showText("Score:" + score, world.getWidth()-50,9);
        world.showText("health:" + health, world.getWidth()-50,25);
    }

    private void checkKeyPress(){
        if(Greenfoot.isKeyDown("space")){
            shootLaser();
        }
    }

    private void shootLaser(){
        Laser laser=new Laser(5);
        Laser laser2=new Laser(5);
        getWorld().addObject(laser,getX(),getY()-20);
        getWorld().addObject(laser2,getX(),getY()+20);
    }

    public void shipdecreaseHealth() {
        health--;
        if (health <= 0) {

            getWorld().removeObject(this);
            Greenfoot.setWorld(gameOver);
        }
    }

    public void increaseScore() {
        score++;
        scoreboard.saveScores();
    }

    public void stopped(){
        scoreboard.saveScores();
    }

    public void checkScore(){
        if(score>10){
            Greenfoot.setWorld(newLevel);
        }
    }

    public void addedToWorld(World world)
    {
        music = new GreenfootSound("audio2.mp3");
    }

    public void setScoreboard(Scoreboard scoreboard) 
    {
        this.scoreboard = scoreboard; 
    }
}
