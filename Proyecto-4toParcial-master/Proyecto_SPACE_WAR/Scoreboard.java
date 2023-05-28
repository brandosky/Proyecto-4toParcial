import greenfoot.*; 
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.io.File; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        Score newScore = new Score(playerName, score);
        scores.add(newScore);
        saveScores();
    }
    public void LoadScores(){
   {
        scores.clear();
        
        File file = new File(NamesPoints);
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String playerName = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    Score loadedScore = new Score(playerName, score);
                    scores.add(loadedScore);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo de puntuaciones no existe.");
        }
    }
}
      public void saveScores() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(NamesPoints));
            for (Score score : scores) {
                writer.write(score.getPlayerName() + "," + score.getScore());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       public void showScores() {
        GreenfootImage image = new GreenfootImage(200, 200);
        image.setColor(Color.WHITE);

        // Ordenar las puntuaciones en orden descendente
        Collections.sort(scores, (s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()));

        // Mostrar las puntuaciones en la imagen
        for (int i = 0; i < scores.size(); i++) {
            Score score = scores.get(i);
            image.drawString(score.getPlayerName() + ": " + score.getScore(), 10, 20 * (i + 1));
        }

        setImage(image);
    }

    public void act()
    {
        // Add your action code here.
    }
}
