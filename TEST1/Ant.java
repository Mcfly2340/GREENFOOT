import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Ant extends Actor
{
    int speed;
    boolean verstopt;
    public int transparency;
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }
    
    public void addedToWorld(World world)
    {
        while (isTouching(null))
        {
            setLocation(Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));       
        }
    }
    
    private void AmIDead(){
        if (!verstopt) {
            if(this.isTouching(Rock.class)||this.isTouching(Cactus.class)){
                dead();
            }
        }
    }
    
    protected boolean foundTumbleweed(){
        Actor tumbleweed;
        tumbleweed=getOneObjectAtOffset(0,0,Tumbleweed.class);
        if(tumbleweed!=null){
            return true;
        } return false;
    }
    protected boolean foundPlant(){
        Actor plant;
        plant=getOneObjectAtOffset(0,0,Plant.class);
        if(plant!=null){
            return true;
        } return false;
    }
    
    protected void movement(){
        GreenfootImage image = this.getImage(); 
        
        if (Greenfoot.isKeyDown("space")) {
            transparency = 80;
            verstopt = true;
            speed=2;
        }
        
        if(foundTumbleweed()){
            transparency = 100;
            speed=1;
        }
        
        if(foundPlant()){
            transparency = 30;
            verstopt = true;
            speed=1;
        }
        
        if(!foundPlant() && !foundTumbleweed() && !Greenfoot.isKeyDown("space")){
            speed=3;
            verstopt = false;
            transparency = 255;
            if (Greenfoot.isKeyDown("shift")) {
                speed+=2;
            }
        }
        
        AmIDead();
        
        image.setTransparency(transparency);
        
        if (transparency == 255){
                World world;
                Counter counter;
                List lijst;
                Actor blaadje;
                Actor takje;
                blaadje= getOneObjectAtOffset(0,0,Takje.class);
                takje= getOneObjectAtOffset(0,0,Blaadje.class);
                if(blaadje != null){
                    world=getWorld();
                    world.removeObject(blaadje);
                    lijst=world.getObjects(Counter.class);
                    counter=(Counter)lijst.get(0);
                    counter.addScore();
                    
                }
                if(takje != null){
                    world=getWorld();
                    world.removeObject(takje);
                    lijst=world.getObjects(Counter.class);
                    counter=(Counter)lijst.get(0);
                    counter.addScore();
                }
                if (isTouching(Stones.class)){
                    move(-4);
                    if (Greenfoot.isKeyDown("shift")) {
                        move(+-4);
                    }
                }
        }
        
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("a")) dx--;
        if (Greenfoot.isKeyDown("d")) dx++;
        if (Greenfoot.isKeyDown("w")) dy--;
        if (Greenfoot.isKeyDown("s")) dy++;
        if (Greenfoot.isKeyDown("left")) dx--;
        if (Greenfoot.isKeyDown("right"))dx++;
        if (Greenfoot.isKeyDown("up")) dy--;
        if (Greenfoot.isKeyDown("down")) dy++;
        if (dx == 0 && dy == 0) return;
        
        setLocation(getX()+dx*speed, getY()+dy*speed);
        
        if (dx*dy == 0) setRotation(90*(1-dx)+90*(1-dy)*dy*dy);
        else setRotation((135-90*dx)*dx*dy);
    }
    
    protected void dead(){
        int timer = Timer.getFrame();
        if(timer>=0) timer=0;
        int endResult1;
        int score;
        int allScores;
        int level;
        int scoreTimer;
        int scoreScore;
        EndScoreValues scores = new EndScoreValues();
        scoreTimer= scores.returnTimer();
        scoreScore= scores.returnScore();
        GreenfootImage image = new GreenfootImage(100, 20);
        GreenfootImage levelImage = new GreenfootImage(100, 100);
        //int levelCounter=Counter.getLevel();
        //String levelText;
        //levelText=""+levelCounter;
        
        //levelText="totaal aantal voorwerpen = "+ levelCounter;
        //levelText=""+new GreenfootImage(levelText, 100, Color.BLACK, new Color(0,0,0,0));
        
        
        
        
        World myWorld = getWorld();
        Counter countje = new Counter();
        level = Counter.getLevel();
        //add scoreboard
        myWorld.addObject(new ScoreBoard(myWorld.getWidth() / 2, myWorld.getHeight() / 2), myWorld.getWidth() / 2, myWorld.getHeight() / 2);
        //add counters
        //levelImage.drawString("henidnoijvrsr"+level, 20, 20);
        //image.drawString(""+scoreTimer, myWorld.getWidth() / 2, myWorld.getHeight() / 2-40);
        System.out.println(level);
        
        Greenfoot.stop();
    }
}
