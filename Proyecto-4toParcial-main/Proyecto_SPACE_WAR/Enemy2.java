import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{

    private int HEALTH=3;
    private int SPEED=6;
    private int VERTICAL_SPEED=5;
    private int END_Y=550;
    private int START_Y=100;
    public void act()
    {
        super.act();
        super.move();
    }

    @Override
    public void move() {
        super.move();
        setLocation(getX(), getY() + VERTICAL_SPEED);

        // Verifica si se ha alcanzado la posición final en el eje y
        if (getY() >= END_Y) {
            // Cambia la dirección del movimiento vertical
            VERTICAL_SPEED = -VERTICAL_SPEED;
        } else if (getY() <= START_Y) {
            // Cambia la dirección del movimiento vertical
            VERTICAL_SPEED = Math.abs(VERTICAL_SPEED);
        }
    }
}
