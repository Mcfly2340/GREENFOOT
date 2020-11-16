
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Dimension;

public class Counter extends Score
{
    public static int score;
    static int level=1;
    String scoreText;
    
    public Counter(){
        score=0;
        scoreText="totaal aantal voorwerpen = "+score;
        this.setImage(new GreenfootImage(scoreText, 20, Color.BLACK, new Color(0,0,0,0)));
    }
    public void addScore(){
        score++; 
        updateImage();
    }
    
    
    protected void updateImage(){
        MyWorld myWorld = (MyWorld)getWorld();
        scoreText="totaal aantal voorwerpen = "+ score;
        int foodWorld = myWorld.foodAmount;
        this.setImage(new GreenfootImage(scoreText, 20, Color.BLACK, new Color(0,0,0,0)));
        if (score>=10){
            if (score%10==0){
                myWorld.objects(1);
                nextLevel();
            }
        }
    }
    public int nextLevel(){
            level++;
            return level;
    }
    public static int getLevel(){
            return level;
    }
    
    public static int getScore(){
        return score;
    }
    public int getScoreText(){
        int s;
        s = Integer.parseInt(scoreText);
        return s;
    }
}