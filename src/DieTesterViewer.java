import javax.swing.*;
import java.awt.*;

public class DieTesterViewer extends JFrame
{
    private DieTester game;
    private int WINDOW_WIDTH = 1500;
    private int WINDOW_HEIGHT = 750;

    public DieTesterViewer(DieTester game)
    {
        this.game = game;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Kayan's Dice Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

    }

    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);


        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(20f));
        g.drawString("You rolled a: ", 590, 700);
//        g.setColor(Color.BLACK);
//        g.setFont(g.getFont().deriveFont(20f));
        g.drawString(", and a: ", 730, 700);


        g.setColor(new Color(137, 4, 214));
        //g.setColor(Color.RED);
        g.setFont(g.getFont().deriveFont(27f));
        g.drawString("" + game.roll2, 713, 702);
        g.drawString("" + game.roll1, 802, 702);
//      g.setColor(new Color(137, 4, 214));
//      g.setFont(g.getFont().deriveFont(27f));
//      g.drawString("" + game.roll2, 802, 702);

        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(18f));
        g.drawString("Rounds: " + game.rounds, 1325, 50);
        g.drawString("Total: " + game.i, 1325, 80);


        g.setColor(new Color(5, 97, 2));
        //g.setFont(new Font("Courier New", 1, 22));
        g.drawString("Target: 50", 1325, 110);
        g.setColor(Color.BLACK);


      if (game.i == 50)
      {
          g.setColor(Color.BLUE);
          g.setFont(new Font("Times New Roman", 18, 50));
          g.drawString("Hooray you Win!", 560, 375);
      }

      if (game.over50 == true)
      {
          g.setColor(Color.RED);
          g.setFont(g.getFont().deriveFont(33f));
          g.drawString("You went over the target! Back to 0 we go!", 400, 375);
      }



    }


}
