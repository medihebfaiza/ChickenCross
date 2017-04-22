import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Street here.
 * 
 * @author (FAIZA & BENCHRAA) 
 * @version (a version number or a date)
 */
public class Street extends Player
{
    private boolean twoWay ;
    
    
    /**
     * Creates a one-way or two-way Street
     */
    public Street(){
         int flipCoin = Greenfoot.getRandomNumber(2) ;
         if (flipCoin==1){
             twoWay = true ;
         }
         else {
             twoWay = false ;
             setImage(new GreenfootImage("road1.png")) ;
         }
    }
    
    /**
     * Returns if the street is a two-way street
     */
    public boolean isTwoWay(){
        return twoWay ;
    }
   
    /**
     * Act - do whatever the Street wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
