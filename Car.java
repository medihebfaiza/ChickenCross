import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (FAIZA & BENCHRAA) 
 * @version (a version number or a date)
 */
public class Car extends Player
{
    private int speed = 2 ;
    private int direction = 1 ;
    
    /**
     * Creates new car with a random skin 
     */
    public Car(){
        int randomskin = Greenfoot.getRandomNumber(3) ;
        if (randomskin == 0) {
            setImage(new GreenfootImage("Car_Green_Front.png"));
        }
        
        else if (randomskin == 1) {
            setImage(new GreenfootImage("Car_Red_Front.png"));
        }
        else {
            setImage(new GreenfootImage("Car_Purple_Front.png"));
        }
    }
    
    /**
     * Creates new car with specific speed and direction and a random skin
     */
    public Car(int s, int d){
        speed = s ;
        direction = d ;
        if (direction == -1){
            turn(180) ;
        }
        int randomskin = Greenfoot.getRandomNumber(3) ;
        if (randomskin == 0) {
            setImage(new GreenfootImage("Car_Green_Front.png"));
        }
        
        else if (randomskin == 1) {
            setImage(new GreenfootImage("Car_Red_Front.png"));
        }
        else {
            setImage(new GreenfootImage("Car_Purple_Front.png"));
        }
    }
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkCar() ;
    }    
    
    /**
     * Advances the car in it's direction
     * 
     */
    public void run(){
        setLocation(getX(), getY() + speed*direction) ;
    }
    
    /**
     * Checks if the car is out of the world and resets it's position 
     */
    public void checkCar() {
        if (isAtEdge()) {
            if (direction == 1) {
                setLocation(getX(),0) ;
            }
            else {
                setLocation(getX(),ChickenWorld.height-1) ;
            }
        }
        run() ;
    
    }   
}
