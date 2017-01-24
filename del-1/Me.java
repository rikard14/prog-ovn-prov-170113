import greenfoot.*;

/**
 * Facit
 * 
 * @author Rikard Karlsson
 * @version 16-05-23
 */
public class Me extends Actor
{
    private boolean hasTreasure = false;
    /**
     * Act - do whatever the Me wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        removeDirt();
        checkHitEnemy();
        checkHitTreasure();
        checkHitDoor();
    }    
    private void removeDirt()
    {
        removeTouching(Dirt.class);
    }
    
    private void move()
    {      
        //only possible to move in one direction at a time
        if(Greenfoot.isKeyDown("i"))//up
        {
           setLocation(getX(), getY() - 1);
        }
        else if(Greenfoot.isKeyDown("j"))//left
        {
           setLocation(getX() - 1, getY());
        }
        else if(Greenfoot.isKeyDown("k"))//down
        {
           setLocation(getX(), getY() + 1);
        }
        else if(Greenfoot.isKeyDown("l"))//right
        {
           setLocation(getX() + 1, getY());
        }            
    }
    private void checkHitEnemy()
    {
        if (getOneIntersectingObject(Enemy.class) != null)
        {
            getWorld().showText("Game over", 6, 3);
            Greenfoot.stop();
        }
    }

    private void checkHitTreasure()
    {
        if (getOneIntersectingObject(Treasure.class) != null)
        {
            GameWorld world = (GameWorld)getWorld();
            world.addScore(100);       
            hasTreasure = true;
            removeTouching(Treasure.class);
        }                
    }
    private void checkHitDoor()
    {
        if (getOneIntersectingObject(Door.class) != null)
        {
            if (hasTreasure)
            {
                getWorld().showText("You made it", 6, 3);
                Greenfoot.stop();
            }
        }                
        
    }
}
