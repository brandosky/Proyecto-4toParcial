import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;
import greenfoot.Color;
import java.awt.Font;
/**
 * Write a description of class label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor {
    private String text;
    private int fontSize;

    public Label(String text, int fontSize) {
        this.text = text;
        this.fontSize = fontSize;
        updateImage();
    }

    public void setText(String text) {
        this.text = text;
        updateImage();
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(text, fontSize, Color.BLACK, null);
        setImage(image);
    }
}