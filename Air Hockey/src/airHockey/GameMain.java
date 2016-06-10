/* ICS4U1 - Computer Science
 * Game: Air Hockey
 * June 9, 2016
 */
package airHockey;

import javax.swing.JFrame;
import java.awt.Color; 

    /* Main game class used to run the entire game
    */
public class GameMain extends JFrame { 


	private static final long serialVersionUID = 1L;
	
	final static int WINDOW_WIDTH = 600;
    final static int WINDOW_HEIGHT = 400;

    public GameMain() {
      
      
        super(" Air Hockey ");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        add(new PongPanel());
        setVisible(true);

    }
    
    public static void main(String[] args) {
        new GameMain();
    }
}

