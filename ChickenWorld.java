import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This subclass is just an example. You can delete it or change the code if you want.
 * It's not necessary for the scrolling system.
 */
public class ChickenWorld extends ScrollingWorld
{
    static int width = 1000 ;
    static int height = 600 ;
   
    private Scroller scroller ;
    private Chicken chicken ;
    private Hawk hawk ;
    private Score score ;
    
    private int speed = 1 ;
    private int speedVariation = 1 ;
    private int nbCars = 2 ; 
    private int nbCarsVariation = 1 ;
    
    public ChickenWorld() {
        super(width, height, 1);//creates an infinite scrolling world with a screen size of 600 x 400;
        //if you want to limitate the scrolling world you have to use this constructor:
        //super(600, 400, 1, scrollingWidth, scrollingHeight);
        setScrollingBackground(new GreenfootImage("grass.png"));
        createChickenWorld();//this method just adds some objects to the world.
    }
    
    /**
     * Creates the world where the Chicken can move.
     */
    public void createChickenWorld() {
        
        int sideWalkSpace = Greenfoot.getRandomNumber(2)+4 ;
        
        for (int x = (int)(getWidth()/3); x < getWidth() * 12; x += getWidth()/sideWalkSpace) {
                    
                    speed = x / (getWidth()*2) + 1 ;
                    speedVariation = x / (getWidth()*3) + 1 ;
                    nbCars = x / (getWidth()*2) + 2 ;
                    nbCarsVariation = x / (getWidth()*3) + 1 ;
            
                    Street street = new Street() ;
                    addObject(street, x, getHeight()/2);
                    if (street.isTwoWay()){
                        generateCarLine(x-32,1) ;
                        generateCarLine(x+32,-1) ; 
                        generateObstacles(x+96) ;
                        sideWalkSpace = Greenfoot.getRandomNumber(2)+4 ;
                    }
                    else {
                        int d = 2-2*Greenfoot.getRandomNumber(2)-1 ;
                        generateCarLine(x,d) ; 
                        generateObstacles(x+64) ;
                        sideWalkSpace = Greenfoot.getRandomNumber(2)+5 ;
                    }
        }
        
        scroller = new Scroller() ;
        chicken = new Chicken() ;
        score = new Score(chicken.getScore()) ;
        addObject(scroller, getWidth()/2, getHeight()/2);
        addObject(chicken, getWidth()/4-10, getHeight()/2);
        addObject(score, 100, 25) ;
        Greenfoot.playSound("theme.mp3");
    }
    
    /**
     * Generates obstacles at a given horizontal postion
     */
     public void generateObstacles(int position){
        int genPos = 0 ;
        int step = 60 ;
        int obsToGo = 12 ;
        while (obsToGo>0 && genPos<height){
            int flipCoin = Greenfoot.getRandomNumber(2) ;
            if (flipCoin==1){
                addObject (new Obstacle(), position, genPos) ;
                obsToGo-- ;
            }
            genPos += step ;
        }
    }
    
    /**
     * Generates a line of Cars at a given horizontal position 
     */
    public void generateCarLine(int position, int direction){
        int j ;
        int s = speed + Greenfoot.getRandomNumber(speedVariation) ;
        int n = nbCars + Greenfoot.getRandomNumber(nbCarsVariation) ;
        for (j = 0 ; j < n ; j++){
            int carSpace = Greenfoot.getRandomNumber(50) + 150 ; 
            addObject (new Car(s,direction), position,(j*carSpace)%height);
        }
    }
    
    /** 
     * Constructs the initial scenario and the functioning of the game. 
     */      
    public void act() 
    {   
        removeObject(score) ;   
        score = new Score(chicken.getScore()) ;
        addObject(score, 100, 25) ;
        
        scroller.setSpeed((chicken.getX()/(width/4))*2+3) ;
        
        if (chicken.isAtEdge()){
            if (chicken.getY() == 0) {
                chicken.setLocation(chicken.getX(),height-1) ;
            }
            else if (chicken.getX() == 0){}
            else {
                chicken.setLocation(chicken.getX(),0) ;
            }
        }
        if (chicken.hitByCar()){
            Greenfoot.playSound("hit.wav");
            chicken.kill() ;
        }
        if (chicken.isDead()) {
            end() ;
        }
        if (chicken.getX()<= width/8 && hawk == null){
            hawkAttack() ;
        }
        if (hawk != null && hawk.targetCaught()) {
            chicken.getCaught() ;
            end() ;
        }
    }
    /**
     * Plays Hawk Animation
     */
    public void hawkAttack(){
        scroller.stop() ;
        chicken.block() ;
        Greenfoot.playSound("hawk.wav") ;
        Greenfoot.playSound("woosh.wav") ;
        hawk = new Hawk(chicken.getX()+15,chicken.getY()-30) ;
        addObject(hawk, getWidth(), 40);
    }
    
    /**
     * Ends the game
     */
    public void end(){
        addObject(new Meme(),getWidth()/2,getHeight()/2+50) ;
        addObject(new Gameover(),getWidth()/2,100) ;
        Greenfoot.stop();
    }
}
