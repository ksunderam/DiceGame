import javax.swing.*;
import java.awt.*;

public class DieTesterViewer extends JFrame
{
    //instance variables, setting window dimensions, instance of DieTester to access back-end, and also images
    private DieTester game;
    public static int WINDOW_WIDTH = 1500;
    public static int WINDOW_HEIGHT = 750;
    //public static Image diceImg;
    public static Image sadBackground;
    public static Image winBackground;
    public static Image[] diceImages;
    public DieTesterViewer(DieTester game)
    {
        this.game = game;
        //puts dice images into array
        diceImages = new Image[4];
        diceImages[0] = new ImageIcon("Resources/Dice1.png").getImage();
        diceImages[1] = new ImageIcon("Resources/Dice2.png").getImage();
        diceImages[2] = new ImageIcon("Resources/Dice3.png").getImage();
        diceImages[3] = new ImageIcon("Resources/Dice4.png").getImage();
        sadBackground = new ImageIcon("Resources/sadBackground.png").getImage();
        winBackground = new ImageIcon("Resources/winBackground.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Kayan's Dice Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        //so that every time paint is called I paint over what is already there, and the white rectangle makes it
        //look like its being updated
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setColor(Color.BLACK);
        //I have many static variables in DieTester to communicate with the Front-End, and this one says whether or not
        //the game has started so it knows when to take the instructions off the screen
        if (!game.gameStart)
        {
            g.setColor(Color.DARK_GRAY);
            g.setFont(g.getFont().deriveFont(19f));
            g.drawString("Welcome to the Maze...", 100, 200);
            g.drawString("To play this game, you will roll two die:", 100, 250);
            g.drawString("-The first die you roll will either be a 5, 6, or 7 sided die—you choose!", 100, 300);
            g.drawString("-The second die you roll will be a plain 6 sided die, but you will have", 100, 350);
            g.drawString(" the option of taking the minimum or the maximum value of three rolls!", 735, 350);
            g.drawString("Your 'position' in the maze will consist of the sum of all your rolls.", 100, 400);
            g.drawString("Be sure to select your rolls wisely; your target is 50!", 100, 450);
            g.drawString("Anything more than that will reset your position on the board to 0!", 100, 500);
            g.setColor(Color.GREEN);
            g.setFont(g.getFont().deriveFont(25f));
            g.drawString("Good luck!", 650, 600);
        }
        if (game.gameStart)
        {
            //draws the many little die on the screen
            for (int i = 0; i < game.getDices().length; i++)
            {
                game.getDices()[i].draw(g);
            }
            // for at the bottom of the screen saying value of your 2 rolls
            g.setFont(g.getFont().deriveFont(20f));
            g.drawString("You rolled a: ", 590, 700);
            g.drawString(", and a: ", 730, 700);
            g.setColor(new Color(137, 4, 214));
            g.setFont(g.getFont().deriveFont(27f));
            //different color and font for the actual roll values to make them pop
            g.drawString("" + game.roll2, 713, 702);
            g.drawString("" + game.roll1, 802, 702);
            g.setColor(Color.BLACK);
            g.setFont(g.getFont().deriveFont(18f));
            //game stats in top right corner using static vars from back-end
            g.drawString("Turns: " + game.turns, 1325, 50);
            g.drawString("Rounds: " + game.rounds, 1325, 80);
            g.drawString("Total: " + game.i, 1325, 110);
            g.setColor(new Color(5, 97, 2));
            g.drawString("Target: 50", 1325, 140);
            g.setColor(Color.BLACK);
            //draws the big dice in the middle of the game
            g.drawImage(diceImages[0], 650, 275, 200, 200, this);
            //if you've reached the target, it displays the win message
            if (game.i == 50)
            {
                g.setColor(Color.white);
                g.fillRect(650, 275, 200, 200);
                g.drawImage(winBackground, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
                g.setColor(Color.BLUE);
                g.setFont(new Font("Times New Roman", 18, 50));
                g.drawString("Hooray you Win!", 560, 150);
            }
            //if you've gone over the target, it shows sad faces cause you reset back to 0
            if (game.over50)
            {
                g.setColor(Color.white);
                g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
                g.drawImage(sadBackground, 0, 0, WINDOW_WIDTH, WINDOW_HEIGHT, this);
                g.setColor(Color.RED);
                g.setFont(g.getFont().deriveFont(33f));
                g.drawString("You went over the target! Back to 0 we go!", 400, 375);
            }
        }
    }
}
