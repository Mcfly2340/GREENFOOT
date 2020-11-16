import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScoreValues here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScoreValues extends Actor
{
    public int scores;
    int timer=Timer.getFrame();
    int score=Counter.getScore();
    /**
     * Act - do whatever the EndScoreValues wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        returnScore();
        returnTimer();
    }
    public int returnTimer(){
        timer=Timer.getFrame();
        return timer;
    }
    public int returnScore(){
        score=Counter.getScore();
        return score;
    }
}
