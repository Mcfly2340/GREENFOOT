import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Man here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    /**
     * Act - do whatever the Man wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int random;
        move(5);
        setRotation(getRotation()+1);
        random=Greenfoot.getRandomNumber(100);
    if(random<4){
        setRotation(getRotation()+Greenfoot.getRandomNumber(180));
    }
    if(random>96){
        setRotation(getRotation()-Greenfoot.getRandomNumber(180));
    }
    } 
    
    public void addedToWorld(World world)
    {
        while (isTouching(null))
        {
            setLocation(Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));     //random location for asteroids        
        }
    }
}
