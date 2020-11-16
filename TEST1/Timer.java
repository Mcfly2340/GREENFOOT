import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Timer extends Actor
{
    public static int frame = 0;
    
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        frame++;
        this.setImage(new GreenfootImage(""+frame/60, 50, Color.BLACK, new Color(0,0,0,0)));
    }    
    public Timer(){
        
    }
    public static int getFrame(){
        return frame;
    }
}
