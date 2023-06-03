import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private int health=3;
    private int speed=1;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getWorld()!=null){
            move();
        }
    }

    protected void move() {
        setLocation(getX(), getY()- speed);

        if (Greenfoot.getRandomNumber(100) < 5) {
            turn(Greenfoot.getRandomNumber(91) - 45); // Girar aleatoriamente en un ángulo entre -45 y 45 grados
        }

        if (this.isAtEdge()) {
            World world=getWorld();

            getWorld().removeObject(this); // Eliminar la nave extraterrestre cuando salga de la pantalla
        }

    }

    protected void decreaseHealth() {
        health--;

        if (health <= 0) {
            World world=getWorld();

            getWorld().removeObject(this); // Eliminar la nave enemiga cuando su salud llegue a cero
        }
    }
}
