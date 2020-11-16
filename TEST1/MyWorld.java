import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

    public class MyWorld extends World
    {
    public int worldWidth = 1000;
    public int worldHeight = 600;
    private int level=1;
    private GreenfootSound sound;
    private int timer;
    int foodAmount=0;
    int teller=0;
    int maxScore = 5;
    int rNumber=Greenfoot.getRandomNumber(3600);
    
    Counter counter;
    Timer timer2 = new Timer();
    Ant ant = new Ant();
    
    public MyWorld(){    
        super(1000, 600, 1);
        prepare();
        sound=new GreenfootSound("Effect.mp3");
    }
    public void act(){
        timer++;
        if (Greenfoot.isKeyDown("space")) {
            if(timer>=10){
            addObject(new Particle(), ant.getX(), ant.getY());
            timer=0;
            }
        }
    }
    
    public void started(){
        sound.playLoop();  
    }
    public void stopped(){
        sound.stop();
    }
    
    public void prepare(){
        generateMainObjects();
        int score=counter.getScore();
    }

    public void generateMainObjects(){
        counter=new Counter();
        addObject(ant, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
        addObject(new Rock(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
        addObject(timer2,975, 20);
        addObject(counter, 120, 20);
        objects(6);
    }
    public void objects(int objectAmount){
        Ant ant = new Ant();
        Cactus cactus = new Cactus();
        Plant plant = new Plant();
        Tumbleweed tumbleweed=new Tumbleweed();
        Stones stones=new Stones();
        for(teller=0;teller<objectAmount;teller++){
            addObject(new Cactus(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600)); 
            addObject(new Plant(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
            addObject(new Tumbleweed(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
            addObject(new Stones(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
        }
        foodObjects(5);
    }
    public void foodObjects(int foodAmount){
        for(teller=1;teller<=foodAmount;teller++){
            addObject(new Takje(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
            addObject(new Blaadje(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
        }
        for(teller=1;teller>=foodAmount;teller++){
            if(foodAmount %10==0){
                addObject(new Takje(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600));
                addObject(new Blaadje(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(600)); 
            }
        }
        setPaintOrder(Counter.class, Timer.class, ScoreBoard.class, Rock.class, Tumbleweed.class, Ant.class, Stones.class, Takje.class, Blaadje.class, Cactus.class);
    }
}
