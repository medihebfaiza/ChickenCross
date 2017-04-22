import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is just an example. You can delete it or change the code.
 * It's not necessary for the scrolling system.
 */
public class Scroller extends ScrollingActor
{
    private int speed = 3;
    private int actStep = 0 ;
    
    
    public Scroller() {
        
    }
    
    /**
     * Sets the speed of the Scroller
     */
    public void setSpeed(int s){
        speed = s ;
    }
    
    /**
     * Here you can tell your actor what he has to do.
     */
    public void act() {
        if (actStep == 0) {
            setLocation(getX() + speed, getY());
            actStep = 6 ;
        }
        else {
            actStep-- ;
        }
    }
    
    /**
     * Stops the scroller
     */
    public void stop() {
        speed = 0 ;
    }
}