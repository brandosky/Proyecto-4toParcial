import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
     private int Laserspeed=10;
    
    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
       public Laser(int Laserspeed) {
        this.Laserspeed = Laserspeed;
    }
    public void act()
    {   
        move();
        checkCollision();
            // Add your action code here.
    }
     private void move() {
        setLocation(getX() +Laserspeed, getY()); 
        if (getX() >= 0) {
            getWorld().removeObject(this); // Eliminar el láser cuando salga de la pantalla
        }
    }

    private void checkCollision() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            getWorld().removeObject(this);
            enemy.decreaseHealth();
            //getWorld().removeObject(enemy); Disminuir la salud de la nave enemiga al colisionar con el láser
        }
    }

}
