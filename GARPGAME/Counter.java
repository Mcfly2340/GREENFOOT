import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Score
{
    int frame = 0;
    private int score;
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frame++;
        this.setImage(new GreenfootImage(""+frame/60, 50, Color.Yellow, Color.Blue));
    } 
    public Counter(){
        String scoreText;
        GreenfootImage image;
        image = new GreenfootImage(10,100);
        score=00;
        scoreText="Aantal Diamanten: "+score;
        
    }
}
