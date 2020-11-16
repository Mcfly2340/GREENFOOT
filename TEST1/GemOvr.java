import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GemOvr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GemOvr extends Actor
{
    /**
     * Act - do whatever the GemOvr wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        String scoreText = "gemOvr" + Counter.score;
        this.setImage(new GreenfootImage(scoreText, 20, Color.BLACK, new Color(0,0,0,0)));
        // Add your action code here.
    }    
}
