import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tumbleweed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tumbleweed extends Actor
{
    /**
     * Act - do whatever the Tumbleweed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int random;
        move(1);
        setRotation(getRotation()+1);
        random=Greenfoot.getRandomNumber(100);
    if(random<1){
        setRotation(getRotation()+200);
    }
    if(random>99){
        setRotation(getRotation()-200);
        setRotation(getRotation()+270);
    }
    }
    protected boolean atWorldEdge(){
        int x, i, wx;
        x=getX();
        i=getImage().getWidth()/2;
        wx=getWorld().getWidth()-i;
        turn(90);
        if(x>=wx){
            return true;
        }
        return false;
        
    }
}    
