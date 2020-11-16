import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    int speed = 3;
    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    GreenfootImage img = getImage();
    boolean links = true;
    public Character(){
        imageLeft = new GreenfootImage("GarpLeft.png");
        imageRight = new GreenfootImage("GarpRight.png");
    }
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        movingAndTurning();
        collectingDiamonds();
        foundBomb();
}
protected void collectingDiamonds(){
        World world;
        Actor emerald;
        emerald= getOneObjectAtOffset(0,0,Emerald.class);
        if(emerald != null){
            world=getWorld();
            world.removeObject(emerald);
        }
}
protected void movingAndTurning(){
        if (Greenfoot.isKeyDown("up")) {
            this.setLocation(getX(), getY() - speed);
            this.setRotation(0);
        }
        if (Greenfoot.isKeyDown("down")) {
            this.setLocation(getX(), getY() + speed);
            this.setRotation(0);
        }
        if (Greenfoot.isKeyDown("left")) {
            this.setLocation(getX() - speed, getY());
            if (links){
            img.mirrorHorizontally();
            setImage(img);
            links=false;
        }
        if(foundRock()){
        move(5);
    }
            this.setRotation(0);
        }
        if (Greenfoot.isKeyDown("right")) {
            this.setLocation(getX() + speed, getY());
            if (!links){
            img.mirrorHorizontally();
            setImage(img);
            links=true;
        }
        this.setRotation(0);
        if(foundRock()){
        move(-5);
    }
    }
    
}
protected boolean foundRock(){
    Actor rock;
    rock=getOneObjectAtOffset(0,0,Rock.class);
    if(rock!=null){
        return true;
    } return false;
}
public void foundBomb(){
 Actor bomb;
 
 bomb=getOneObjectAtOffset(0,0,Bomb.class);
 if(bomb!=null){
     getWorld().removeObject(bomb);
     getWorld().addObject(new Explosion(), getX(), getY());
     getWorld().removeObject(this);
    }
}
}

