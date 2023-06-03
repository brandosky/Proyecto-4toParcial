import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Laser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Laser extends Actor
{
    private int Laserspeed=5;
    private int scoreValue;
    private int cont;

    /**
     * Act - do whatever the Laser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Laser(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public void act()
    {   
        if(checkCollision()==1){
            getWorld().removeObject(this);
        }
        if(getWorld()!=null){
            move();   
        }
    }

    private void move() {
        setLocation(getX() -Laserspeed, getY()); 
        if (this.isAtEdge()) {
            getWorld().removeObject(this); // Eliminar el láser cuando salga de la pantalla
        }
    }

    private int checkCollision() {
        cont=0;
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            enemy.decreaseHealth();
            cont=1;
            //getWorld().removeObject(enemy); Disminuir la salud de la nave enemiga al colisionar con el láser
        }
        return cont;
    }
}
