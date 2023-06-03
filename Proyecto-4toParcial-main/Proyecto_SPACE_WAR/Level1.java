import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nivel_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class nivel_1.
     * 
     */
    private Ship ship;
    private Scoreboard scoreboard;
    public int score;
    private String PointsName="puntuacion.txt";
    public Level1()
    {
        super(1000,600,1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ship=new Ship(new Level2(),new GameOver());
        addObject(ship, getWidth() -100, getHeight() -300);
        createStaticObjects();
        createMovingObjects();
        Home home = new Home();
        addObject(home,52,548);
        //addObject(scoreboard,100,50);
    }

    private void createStaticObjects() {
        PowerUpPointsPlus powerUp1 = new  PowerUpPointsPlus(10);
        addObject(powerUp1, 200, 50);

        PowerUpPointsPlus powerUp2 = new  PowerUpPointsPlus(20);
        addObject(powerUp2, 600, 50);
    }

    private void createMovingObjects() {
        for (int i = 0; i < 3; i++) {
            Enemy alien = new Enemy();
            int x = getWidth() - Greenfoot.getRandomNumber(500)-200;
            int y = getHeight() - Greenfoot.getRandomNumber(500);
            addObject(alien, x, y);
        }
    }

    public void increaseScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }
}
