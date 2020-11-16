import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Takje extends Actor
{
    /**
     * Act - do whatever the Bug1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setRotation(getRotation()+1);
    }    
    public void addedToWorld(World world)
    {
        while (isTouching(null))
        {
            setLocation(Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));        
        }
    }
}
