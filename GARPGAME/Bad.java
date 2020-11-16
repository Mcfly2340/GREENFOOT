import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bad extends Actor
{
    /**
     * Act - do whatever the Bad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int random;
        
        move(7);
        if(atWorldEdge()){
            move(-3);
            setRotation();
    }else{
    random=Greenfoot.getRandomNumber(100);
    if(random<4){
        setRotation(getRotation()+Greenfoot.getRandomNumber(180));
    }
    if(random>96){
        setRotation(getRotation()-Greenfoot.getRandomNumber(180));
    }
}
lookForCharacter();
lookForActor();
}
    public Bad(){
        setRotation();
    }
    protected void setRotation(){
    if(Greenfoot.getRandomNumber(100)<50){
             setRotation(getRotation()+Greenfoot.getRandomNumber(180)); 
            }else{
             setRotation(getRotation()-Greenfoot.getRandomNumber(180));
            }
        }
    protected boolean atWorldEdge(){
        int x, i, wx;
        x= getX();
        i=getImage().getWidth()/2;
        wx=getWorld().getWidth()-i;
        if(x>=wx){
            return true;
        }
        return false;
        
    }
    protected void lookForActor(){
        Actor actor;
        actor=getOneObjectAtOffset(0,0,Actor.class);
        if((actor!=null))
            turn(90);
    }
    protected void lookForCharacter(){
     Actor garp;
     
     garp=getOneObjectAtOffset(0,0,Character.class);
     if(garp!=null)
        Greenfoot.playSound("scream.mp3");
        getWorld().removeObject(garp);
    }
}
