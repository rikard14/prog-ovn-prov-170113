import greenfoot.*;
import java.util.List;
/**
 * Facit
 * 
 * @author Rikard Karlsson
 * @version 16-05-23
 */
public class GameWorld extends World
{
    private int score = 0;
    private final static int NO_ROWS = 5;
    private final static int NO_COLUMNS = 8;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(NO_COLUMNS, NO_ROWS, 50); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Me.class, Enemy.class, Treasure.class, Door.class, Dirt.class);

        addDirt();

        removeDirtAt(5, 3);
        Treasure treasure = new Treasure();
        addObject(treasure, 5, 3);
        
        removeDirtAt(3, 0);
        Treasure treasure2 = new Treasure();
        addObject(treasure2, 3, 0);

        removeDirtAt(2, 1);
        Enemy enemy = new Enemy();
        addObject(enemy, 2, 1);
        removeDirtAt(2, 2);
        removeDirtAt(3, 2);
        removeDirtAt(2, 3);
        removeDirtAt(3, 3);

        Enemy enemy2 = new Enemy();
        addObject(enemy2, 3, 2);

        removeDirtAt(0, 0);
        Me me = new Me();
        addObject(me,0, 0);

        removeDirtAt(7,4);
        Door door = new Door();
        addObject(door, 7, 4);  
    }


    private void addDirt()
    {
        int row = 0;
        while(row < NO_ROWS)
        {
            int column = 0;
            while(column < NO_COLUMNS)
            {
                addObject(new Dirt(), column, row);
                ++column;
            }
            ++row;
        }
    }
    private void removeDirtAt(int x, int y)
    {
        List<Actor> actors = getObjectsAt(x, y, Actor.class);
        if (actors != null)
        {
            removeObject(actors.get(0));
        }
    }
    public void addScore(int points)
    {
        score += points;
    }
    public void act()
    {
        showScore();
    }
    private void showScore()
    {
        showText("Score: " + score, 2, 1);
    }
}
