import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hawk here.
 * 
 * @author (FAIZA & BENCHRAA) 
 * @version (a version number or a date)
 */
public class Hawk extends Player
{
    private int wing = 1 ;
    private int targetX = 15 ;
    private int targetY = 300 ;
    private boolean targetCaught = false ;
    
    /**
     * Creates new hawk with a given target
     */
    public Hawk(int tX, int tY){
        targetX = tX ;
        targetY = tY ;
    }
    
    public void setTarget(int tX, int tY){
        targetX = tX ;
        targetY = tY ;
    }
    
    /**
     * Act - do whatever the Hawk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (wing >= 16){
            setImage(new GreenfootImage("hawk.png")) ;
            wing = 1 ;
        }
        else if (wing >= 12){
            setImage(new GreenfootImage("hawk3.png")) ;
            wing ++ ;
        }
        else if (wing >= 8){
            setImage(new GreenfootImage("hawk2.png")) ;
            wing ++ ;
        }
        else {
            setImage(new GreenfootImage("hawk.png")) ;
            wing ++ ;
        }// Add your action code here.
        
        if (getX()>=targetX) setLocation(getX()-15,getY()) ;
        if (getY()<=targetY && getX()<=(ChickenWorld.width/2)) setLocation(getX(),getY()+20) ;
        
        if (getX()<targetX && getY()>targetY && !targetCaught) {
            targetCaught = true ;
            Greenfoot.playSound("stab.wav") ;
        }
        
    }    
    
    /**
     * Returns if the target has been killed 
     */
    public boolean targetCaught(){
        return targetCaught ;
    }
}
