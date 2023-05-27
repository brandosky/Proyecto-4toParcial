import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nivel_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends Levels
{

    /**
     * Constructor for objects of class nivel_1.
     * 
     */
    private Ship ship;
    private Scoreboard scoreboard;
    private int score;
    private String PointsName="puntuacion.txt";
    private int EnemySpeed = 1;
    private String scoreText;
    public Level_1()
    {
        //super(1000,600,1);
        scoreboard=new Scoreboard(PointsName);
        scoreboard.LoadScores();
        prepare();
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ship=new Ship();
        addObject(ship, getWidth() / 2, getHeight() - 50);
        createStaticObjects();
        createMovingObjects();
        Home home = new Home();
        addObject(home,52,548);
        Nave_1 nave_1 = new Nave_1();
        addObject(nave_1,914,140);
    }
       private void createStaticObjects() {
        PowerUpPointsPlus powerUp1 = new  PowerUpPointsPlus(10);
        addObject(powerUp1, 200, 300);

        PowerUpPointsPlus powerUp2 = new  PowerUpPointsPlus(20);
        addObject(powerUp2, 600, 400);
    }

    private void createMovingObjects() {
        for (int i = 0; i < 3; i++) {
            Enemy alien = new Enemy(EnemySpeed);
            int x = getWidth() + Greenfoot.getRandomNumber(400);
            int y = Greenfoot.getRandomNumber(getHeight() - 200) + 100;
            addObject(alien, x, y);
        }
    }
    public void stopped(){
        scoreboard.saveScores();
    }

    public void increaseScore(int points) {
        score += points;
    }
    
    public int getScore() {
        return score;
    }
}
