/* ICS4U1 - Computer Science
 * Game: Air Hockey
 * June 9, 2016
 */
package airHockey;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/** The game class, used to initialize variables
  */
public class Game {
  
  int pScore = 0; 
  int aiScore = 0; 
  
  boolean reset=false;
  boolean endGame=false;
  boolean paddleHit=false;
  
  String winner; 
  Paddle playerPaddle = new Paddle (0,150,90,10);
  Paddle computerPaddle = new Paddle (585,150,90,10);
  Ball ball = new Ball (240,120,10,10);
  
  public Game () {   
    
  }
  
  /** The paint method, used to draw out and fill in shapes & lines
    * @param g - graphics variable used to set and fill colour
    */
  
  public void paint (Graphics g) {
	  
    g.setColor (Color.BLACK);
    g.fillRect(0, 0, 600, 400);
    
    if (reset==false){
    	
      ball.paint(g); 
      playerPaddle.paint(g);
      computerPaddle.paint(g);
      
      String score1 = String.valueOf(pScore);
      
      g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
      g.setColor(Color.GREEN);
      
      g.drawString("Player: "+score1,150,45);       
      String score2 = String.valueOf(aiScore);      
      g.drawString("Computer: "+score2,400,45);       
      
      
      g.drawLine(300,0,300,400);
      g.drawLine(0,50,600,50);
      g.drawOval(275, 175, 50, 50);      
      
      
    }else{
    	
      if (endGame==false) {
    	  
    	  playerPaddle = new Paddle (0,150,90,10);
    	  computerPaddle = new Paddle (585,150,90,10);
    	  ball = new Ball (240,120,10,10);
    	  reset=false;
    	  
      }else{
    	  
    	  Font myFont = new Font ("Times New Roman", 1, 20);
    	  g.setColor(Color.CYAN);
    	  g.setFont(myFont);
    	  g.drawString(winner , 120, 200);
      }
    }
    
    /* update method for score and winner, 5 points win
     * 
     */
  }
  public void update (){
	  
    if (ball.getX() <5  ){
      reset = true;
      aiScore++;
      
      if (aiScore == 5){
        endGame=true;
        winner = "Computer Wins !! Better luck next time!"; 
      }
      
    } else if (ball.getX() > 590){
    	
      reset = true; 
      pScore++;
      
      if (pScore==5){
        endGame=true;
        winner = "Player Wins !!"; 
      } 
      
    }else{
      int speed; 
      
      if (paddleHit){
        speed=8;        
      }else{
        speed=8;
      }
      
      ball.update (600, speed, 370) ;
      computerPaddle.update (ball.getX(), ball.getY()); 
    }   
    
    // collision with human paddle 
    
    
    if ((ball.getX() < 10) && ((ball.getY() > playerPaddle.getY() || ball.getY() + 25 > playerPaddle.getY())&&(ball.getY()<playerPaddle.getY()+playerPaddle.getLength()))){
      ball.paddleHit();
      paddleHit=true; 
    }
    // collision with computer paddle
    if ((ball.getX()> 575) && ((ball.getY()>computerPaddle.getY() || ball.getY()+25>computerPaddle.getY())&&(ball.getY()<computerPaddle.getY()+computerPaddle.getLength()))){
      ball.paddleHit();
      paddleHit=true;
    }
  }
  /* movehumanpaddle method used to change directions of player paddle
   * @param e - used as a variable for keyboard recognizition
   */
  public void moveHumanPaddle(KeyEvent e){
	  
    if(e.getKeyCode() == KeyEvent.VK_DOWN){
      this.playerPaddle.change (10);
    } else if(e.getKeyCode() == KeyEvent.VK_UP){
      this.playerPaddle.change (-10);
      
    } 
  }
}




