import greenfoot.*;

/**
 * Facit Enemy
 * 
 * @author Rikard Karlsson
 * @version 16-05-23
 */
public class Enemy extends Actor
{
    public void act() 
    {
        if(isEmptyAhead())
        {
            move(1);
        }
        else
        {
            int number = Greenfoot.getRandomNumber(3) + 1; //1, 2, 3
            turn(90 * number);
        }
    }    
    private boolean isEmptyAhead()
    {
        int direction = getRotation();
        if (direction == 0)
        {
            if (getX() == 7)
            {
                return false;
            }
            return getOneObjectAtOffset(1, 0, Dirt.class) == null;

        }
        else if (direction == 90)
        {
            if (getY() == 4)
            {
                return false;
            }
            return getOneObjectAtOffset(0, 1, Dirt.class) == null;
        }
        else if (direction == 180)
        {
            if (getX() == 0)
            {
                return false;
            }
            return getOneObjectAtOffset(-1, 0, Dirt.class) == null;
        }
        else if (direction == 270)
        {
            if (getY() == 0)
            {
                return false;
            }
            return getOneObjectAtOffset(0, -1, Dirt.class) == null;
        }
        return false;
    }
}
