import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUpPointsPlus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUpPointsPlus extends Actor
{
    private int scoreValue;

    private int speed = 1;

    public PowerUpPointsPlus(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void act()
    {
        checkCollision();
        move();
    }

    private void move() {
        setLocation(getX(), getY() + speed); // Mover el objeto de puntuación hacia abajo
        Enemy enemy=new Enemy();
        if (this.isAtEdge()) {
            World world=getWorld();
            world.addObject(enemy,Greenfoot.getRandomNumber(800),Greenfoot.getRandomNumber(450));
            getWorld().removeObject(this); // Eliminar el objeto de puntuación cuando salga de la pantalla
        }
    }

    private void checkCollision() {
        Ship spaceship = (Ship) getOneIntersectingObject(Ship.class);
        World mundoActual=getWorld();
        if (spaceship != null) {
            if(mundoActual instanceof Level1) {
                Enemy enemy=new Enemy();
                World world=getWorld();
                world.addObject(enemy,Greenfoot.getRandomNumber(800),Greenfoot.getRandomNumber(150)); 
            }else{if(mundoActual instanceof Level2) {
                    Enemy2 enemy=new Enemy2();
                    World world=getWorld();
                    world.addObject(enemy,Greenfoot.getRandomNumber(800),Greenfoot.getRandomNumber(150));                
                }else{if(mundoActual instanceof Level3) {
                        Enemy2 enemy=new Enemy2();
                        Enemy enemy1=new Enemy();
                        World world=getWorld();
                        world.addObject(enemy1,Greenfoot.getRandomNumber(800),Greenfoot.getRandomNumber(150));                    
                        world.addObject(enemy,Greenfoot.getRandomNumber(800),Greenfoot.getRandomNumber(150));                    
                    }
                }
            }
            getWorld().removeObject(this);
            spaceship.increaseScore(); // Aumentar la puntuación de la nave espacial al succionar el objeto de puntuación
        }
    }
}

