    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class MyWorld here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class GarpsWorld extends World
    {
        Character garp = new Character();
        Counter counter = new Counter();
        Bad thief = new Bad();
        int teller;
        private GreenfootSound sound;
        private GreenfootImage[] images;
        /**
         * Constructor for objects of class MyWorld.
         * 
         */
        public GarpsWorld()
        {    
            // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
            super(600, 400, 1); 
            populateTheWorld();
            sound=new GreenfootSound("musicmix.mp3");
    }
    public void started(){
        sound.playLoop();
    }
    public void stopped(){
        sound.stop();
    }
    protected void populateTheWorld(){
        
        addObject(garp, 30, 70);
        addObject(counter, 575, 20);
        addObject(thief, Greenfoot.getRandomNumber(670)+15, Greenfoot.getRandomNumber(470)+15);
        for(teller=0; teller<10;teller++){
        addObject(new Emerald(), Greenfoot.getRandomNumber(700),Greenfoot.getRandomNumber(500));
        }
        for(teller=0; teller<6;teller++){
        addObject(new Rock(), Greenfoot.getRandomNumber(700),Greenfoot.getRandomNumber(500));
        }
        for(teller=0; teller<4;teller++){
        addObject(new Bomb(), Greenfoot.getRandomNumber(700),Greenfoot.getRandomNumber(500));
        }
        setPaintOrder(Counter.class, Character.class, Bad.class, Emerald.class, Bomb.class, Rock.class);
    }
}
