import java.util.Scanner;

public class DieTester
{
    private static DieTesterViewer x;
    public static int i;
    public static int totalRoll;
    public static int roll1;
    public static int roll2;
    public static boolean over50;
    public static int rounds;

    public DieTester()
    {
        x = new DieTesterViewer(this);
        i = 0;
        roll1 = 0;
        roll2 = 0;
        over50 = false;
        rounds = 0;
    }

    public static void printGreeting() {
        //instructions for game
        System.out.println("Welcome to the Maze...");
        System.out.println("To play this game, you will roll two die:");
        System.out.println("-the first die you roll will either be a 5, 6, "
                + "or 7 sided die—you choose!");
        System.out.println("-the second die you roll will be a plain 6 sided "
                + "die, but you will have the option of taking the minimum or the "
                + "maximum value of three rolls!");
        System.out.println("Your 'position' in the maze will consist of the "
                + "sum of all your rolls.");
        System.out.println("Make sure to choose your rolls wisely, as the exit "
                + "to the maze is at position 50!\nAnything more than that will reset "
                + "your position on the board to 0!");
        System.out.println("Good luck!\n");
    }

    public static void gameLoop()
    {
        while (i < 50 || i > 50)
        {
            totalRoll = 0;
            x.repaint();
            //roll2 = 0;
            //loops the maze back around to position 0 if one goes over 50
            if (i > 50)
            {
                over50 = true;
                rounds++;
                i = 0;
                System.out.println("Oh no, you've jumped over the 50 target! "
                        + "Back to position 0 you go!");
            }
            //asks user to pick how many sides for die, and keeps asking until 
            //user picks within the range of 5-7
            System.out.println("\nPlease pick between a 5, 6, or 7 sided die.");
            Scanner input = new Scanner(System.in);
            int num = 0;
            do
            {
                num = input.nextInt();
            }
            while (num < 5 || num > 7);
            over50 = false;

            //rolling die with user chosen # of sides
            //1 method
            //x.repaint();
            Die d2 = new Die(num);
            System.out.println(d2);
            System.out.println("Rolling the die: ");
            //2 method
            roll2 = d2.roll();
            System.out.println(roll2);
            roll1 = 0;
            x.repaint();

            System.out.println("\nFor your second roll, you can choose to take "
                    + "the maximum value of 3 rolls on a six-sided die, or the "
                    + "minimum value.");
            System.out.println("Please type in '1' to select the MAX value "
                    + "or '0' to choose the MIN.");

            //asks user if they want to getMin or MAX, 
            //keeps repeating until user types in either 1 or 0
            int maxminVal = 2;
            do
            {
                maxminVal = input.nextInt();
            }
            while (maxminVal < 0 || maxminVal > 1);

            //declares new 6 sided die
            Die d1 = new Die();

            //checks whether user wants max or min, proceeds to calculate rolls
            roll1 = 0;
            if (maxminVal == 1)
            {
                System.out.println("You picked MAX");
                // Gets the max of 3 rolls
                //3 method
                roll1 = d1.getMaxRoll(3);
                System.out.println("\nMax of 3 rolls on the 6-sided die:\n"
                        + roll1);

            }
            else if (maxminVal == 0)
            {
                System.out.println("You picked MIN");
                // Gets the min of 3 rolls
                //additional self-made method
                roll1 = d1.getMinRoll(3);
                System.out.println("\nMin of 3 rolls on the 6-sided die:\n"
                        + roll1);
            }

            //adds up the two rolls
            totalRoll = roll1 + roll2;
            System.out.println("\nThe total value of your rolls are "
                    + totalRoll + ".");

            //calculates position on the board
            i = totalRoll + i;
            System.out.println("You are now at position "
                    + i + " on the board.\n");

            x.repaint();
        }
    }

    public static void playGame() {
        DieTester x = new DieTester();
        printGreeting();
        gameLoop();
        System.out.println("\nYAY! You're out of the maze! You've reached the magic door at position 50!\nCongratulations!");
    }

    public static void main(String[] args) {
        //printGreeting();
        playGame();
    }
}