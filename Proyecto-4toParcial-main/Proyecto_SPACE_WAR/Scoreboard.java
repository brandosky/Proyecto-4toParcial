import greenfoot.*; 
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.io.File; 
import greenfoot.GreenfootImage;
import greenfoot.Actor;
import greenfoot.Greenfoot;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    private ArrayList<Score> scores;
    private String NamesPoints;
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Scoreboard(String NamesPoints){
        scores=new ArrayList<>();
        this.NamesPoints=NamesPoints;
    }

    public void addScore(String playerName, int score) {
        if(isValidPlayerName(playerName) && isValidScore(score)){
            Score newScore = new Score(playerName, score);
            scores.add(newScore);
            saveScores();
        }
    }

    public void loadScores() {
        scores.clear();
        File file = new File(NamesPoints);
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String playerName = parts[0];
                        int score = Integer.parseInt(parts[1]);
                        Score loadedScore = new Score(playerName, score);
                        scores.add(loadedScore);
                    }
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Error loading scores: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo de puntuaciones no existe.");
        }
    }

    public void saveScores() {
        try {
            File file = new File(NamesPoints);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Score score : scores) {
                writer.write(score.getPlayerName() + "," + score.getScore());
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving scores: " + e.getMessage());
        } 
    }

    public void showScores() {
        World world = getWorld();
        // Ordenar las puntuaciones en orden descendente
        Collections.sort(scores, (s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()));
        int yPos = 20; // Posición vertical inicial

        // Mostrar las puntuaciones en el mundo como etiquetas de texto
        for (int i = 0; i < scores.size(); i++) {
            Score score = scores.get(i);
            String scoreText = score.getPlayerName() + "      " + score.getScore();
            Label scoreLabel = new Label(scoreText, 60);
            world.addObject(scoreLabel, world.getWidth() / 2, yPos);
            yPos += 30; // Incrementar la posición vertical para la siguiente puntuación
        }
    }

    private boolean isValidPlayerName(String playerName) {
        return !playerName.isEmpty();
    }

    private boolean isValidScore(int score) {
        return score >= 0;
    }

    public void act()
    {
        // Add your action code here.
    }
}
