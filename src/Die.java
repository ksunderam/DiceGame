import java.awt.*;

public class Die
{
    /** Instance Variables **/
    private int sides;
    private Die d1;
    private Die d2;//
    private int totalRoll;
    private int num;
    private int maxminVal;
    private DieTesterViewer game;
    //private Image[] dices;
    private int x;
    private int  y;
    private int width;
    private int height;

    /** Constructors **/
    public Die()
    {
        sides = 6;
    }

    public Die(int numSides)
    {
        sides = numSides;
    }

    public Die(DieTesterViewer game)
    {
        //creating a random spot to put the tiny dice image
        this.game = game;
        this.width = game.WINDOW_WIDTH;
        this.height = game.WINDOW_HEIGHT;
        this.x = (int) (Math.random() * width * 0.8);
        this.y = (int) (Math.random() * height * 0.8);
    }

    /** Methods **/
    public int getSides()
    {
        return sides;
    }

    /**
     * Returns a random int between 1 and
     * the number of sides on the Die
     */
    public int roll()
    {
        int num = (int)(Math.random()*sides) + 1;
        return num;
    }

    /**
     * Rolls the dice the numRolls times
     * and returns the max value of the rolls
     */
    public int getMaxRoll(int numRolls)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<numRolls; i++)
        {
            int num = roll();
            max = Math.max(max, num);
        }
        return max;
    }

    /**
     * TODO: Write a method that rolls the
     * die numRolls times and returns the
     * min value of the rolls
     */

    public int getMinRoll(int numRolls)
    {
        //keeps int min at the highest possible valye
        int min = Integer.MAX_VALUE;
        for(int i=0; i<numRolls; i++)
        {
            int num = roll();
            //takes the lowest value and compares with current value,
            //if the current is less, then that becomes the new min value
            min = Math.min(min, num);
        }

        return min;
    }

    public String toString()
    {
        return "\nThis is a " + sides + " sided die.";
    }

    /**
     * Draw
     *
     * This draws a Fish image in the fish's location. It uses dx to determine
     * whether to draw the left-facing fish or the right-facing fish.
     */
    public void draw(Graphics g)
    {
        //depending on the die's random x-coord, we'll draw a die rotated 0, 90, 180, or 279 degrees
        if (x % 4 == 0)
        {
            g.drawImage(game.diceImages[0], x, y, 50, 50, game);
        }
        else if (x % 4 == 1)
        {
            g.drawImage(game.diceImages[1], x, y, 50, 50, game);
        }
        else if (x % 4 == 2)
        {
            g.drawImage(game.diceImages[2], x, y, 50, 50, game);
        }
        else if (x % 4 == 3)
        {
            g.drawImage(game.diceImages[3], x, y, 50, 50, game);
        }
    }
}