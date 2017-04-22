import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meme here.
 * 
 * @author (FAIZA & BENCHRAA) 
 * @version (a version number or a date)
 */
public class Meme extends Menu
{
    /**
     * Act - do whatever the Meme wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    /**
     * Creates a random meme
     */
    public Meme(){
        int random = Greenfoot.getRandomNumber(12)+1 ;
        setImage(new GreenfootImage("memes/meme"+random+".jpg")) ;
    }
}
