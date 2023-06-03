import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nivel_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private Ship ship;
    private Scoreboard scoreboard;
    private int score;
    private String PointsName="puntuacion.txt";
    private String scoreText;
    private Score scoreboardd;
    /*** Constructor for objects of class nivel_3.
     * 
     */
    public Level3()
    {
        super(1000,600,1);
        prepare();
    }

    private void prepare()
    {
        ship=new Ship(new Winner(),new GameOver());
        addObject(ship, getWidth() -100, getHeight() -300);
        createStaticObjects();
        createMovingObjects();
        Home home = new Home();
        addObject(home,52,548);
        //addObject(scoreboard,100,50);
    }

    private void createStaticObjects() {
        PowerUpPointsPlus powerUp1 = new  PowerUpPointsPlus(10);
        addObject(powerUp1, 200,Greenfoot.getRandomNumber(500));
        PowerUpPointsPlus powerUp2 = new  PowerUpPointsPlus(20);
        addObject(powerUp2, 600, Greenfoot.getRandomNumber(500));
        PowerUpPointsPlus powerUp3 = new  PowerUpPointsPlus(10);
        addObject(powerUp3, 800, Greenfoot.getRandomNumber(500));
    }

    private void createMovingObjects() {
        for (int i = 0; i < 3; i++) {
            Enemy2 alien = new Enemy2();
            int x = getWidth() - Greenfoot.getRandomNumber(500)-200;
            int y = getHeight() - Greenfoot.getRandomNumber(500);
            addObject(alien, x, y);
        }
    }
}
