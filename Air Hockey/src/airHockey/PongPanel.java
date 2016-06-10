/* ICS4U1 - Computer Science
 * Game: Air Hockey
 * June 9, 2016
 */
package airHockey;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.Timer;

    /* PongPanel class, used to initilize variables
    * also reates new form PongPanel    
    */
public class PongPanel extends javax.swing.JPanel {
    
    private final Game game;
    private final Paddle humanPaddle;
    private final Paddle computerPaddle;
    private final Ball theBall; 
    
    //Creates new form PongPanel 
    public PongPanel() {
    	
        initComponents();
        
        this.game = new Game ();
        this.humanPaddle = new Paddle (2,120,120,20);
        this.computerPaddle = new Paddle (570,120,120,20); 
        this.theBall = new Ball (270,120,25,25);

        //set a timer
        Timer myTimer = new Timer(30, new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                formActionPerformed(evt);
            }
        });
        
        myTimer.start();
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    private void initComponents() {		
    	addKeyListener(new KeyAdapter() {
    		public void keyPressed(KeyEvent evt){
    			formKeyPressed(evt);
    		}
    	});
		
    	GroupLayout layout = new GroupLayout(this);
    	this.setLayout(layout);
    	layout.setHorizontalGroup(
    			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    			.addGap(0,400,Short.MAX_VALUE)
    			);    	
    	layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
            ); 
	}
    
	@Override
    public void paint ( Graphics g ){
        super.paint(g);
        game.paint(g);
        //this.theBall.paint(g); 
        //this.humanPaddle.paint(g);
        //this.computerPaddle.paint(g);
    }

    //this method runs when a key is pressed	
    private void formKeyPressed(KeyEvent evt) {
    	game.moveHumanPaddle(evt);
    }

    //this method runs once every 30 milliseconds
     private void formActionPerformed(ActionEvent evt) {
        game.update();
        this.repaint(); 
        this.repaint();
     }
}
