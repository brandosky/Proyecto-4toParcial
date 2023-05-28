import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nave_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave_1 extends Naves
{
        private int speed=5;
    private int health=3;
    private int score=0;
    private int cooldown=0;
    /**
     * Act - do whatever the ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        checkCollision();
        checkKeyPress();
        checkFireCooldown();    
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
            cooldown = 20; // Cooldown de disparo
        }
    }
    private void checkCollision(){
        Actor laser=getOneIntersectingObject(Laser.class);
        Actor enemy=getOneIntersectingObject(Enemy.class);
        Actor powerUpPointsPlus=getOneIntersectingObject(PowerUpPointsPlus.class);
        
        if(laser !=null){
        getWorld().removeObject(laser);
        score+=10;
        }
        if(enemy!=null){
            getWorld().removeObject(enemy);
            score+=4;
        }
        if(powerUpPointsPlus!=null){
            getWorld().removeObject(powerUpPointsPlus);
            score+=5;
        }
    } 
    private void checkKeyPress(){
        if(Greenfoot.isKeyDown("space")){
            shootLaser();
        }
    }
    private void shootLaser(){
        Laser laser=new Laser(10);
        getWorld().addObject(laser,getX(),getY()-20);
    }
    
    public void shipdecreaseHealth() {
        health--;
        if (health <= 0) {
              
            getWorld().removeObject(this);
      
        }
    }

    public void increaseScore() {
        score++;
        // Actualizar la puntuación en pantalla
    }
}
