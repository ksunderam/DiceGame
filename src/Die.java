public class Die
{
    /** Instance Variables **/
    private int sides;
    private Die d1;//
    private Die d2;//
    private int totalRoll;//
    private int num;//
    private int maxminVal;

    /** Constructors **/
    public Die()
    {
        sides = 6;
    }

    public Die(int numSides)
    {
        sides = numSides;
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
}