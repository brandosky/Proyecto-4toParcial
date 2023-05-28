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
    
    private int speed = 3;
  
       public PowerUpPointsPlus(int scoreValue) {
        this.scoreValue = scoreValue;
    }
    
    public int getScoreValue() {
        return scoreValue;
    }
    
    public void act()
    {
         move();
        checkCollision();
      
    }
      private void move() {
        setLocation(getX(), getY() + speed); // Mover el objeto de puntuación hacia abajo
        if (getY() >= getWorld().getHeight()) {
            getWorld().removeObject(this); // Eliminar el objeto de puntuación cuando salga de la pantalla
        }
    }

    private void checkCollision() {
        Ship spaceship = (Ship) getOneIntersectingObject(Ship.class);
        if (spaceship != null) {
              ((Level_1) getWorld()).increaseScore(scoreValue);
            getWorld().removeObject(this);
            spaceship.increaseScore(); // Aumentar la puntuación de la nave espacial al succionar el objeto de puntuación
        }
    }
}

