import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends Actor
{
    private double XGRAVITY;
    private double YGRAVITY;
    int teller;
    
    private double x;
    private double y;
    private double dx;
    private double dy;

    /**
     * Create a new particle. The motion velocity (dx/dy) is initialised randomly, so that each new particle will have a random movement direction.
     */
    public Particle()
    {
        int hoeveelheid = Greenfoot.getRandomNumber(3);
        setImage("particle" + hoeveelheid + ".png");
        
        XGRAVITY = getRandomNumber();
        YGRAVITY = getRandomNumber();
    }
    
    /**
     * When we are first added to the world, get the x/y coordinates and store them in doubles, so that we can do more precise (and smoother) motion animation.
     */
    public void addedToWorld(World world)
    {
        x = getX();
        y = getY();
    }

    /**
     * Move the particle according to its velocity and direction and apply gravity.
     */
    public void act()
    {
        teller++;
        if (teller>=30) {
            getWorld().removeObject(this);
        }
        else {
            x = x + dx;
            y = y - dy;
            setLocation((int)x, (int)y);
            dx = dx + XGRAVITY;
            dy = dy + YGRAVITY;
        }
    }
    public double getRandomNumber()
    {
       double normal = (Greenfoot.getRandomNumber(5)-2);
       normal/=10;
       return normal;
    }
}

